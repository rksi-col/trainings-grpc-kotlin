package org.example.controller

import io.grpc.Status
import io.grpc.StatusException
import org.example.domain.AddExerciseToTraining
import org.example.domain.CreateExercise
import org.example.proto.CreateTrainingReq
import org.example.proto.Empty
import org.example.proto.GetTrainingReq
import org.example.proto.GetTrainingResp
import org.example.proto.TrainingsServiceGrpcKt
import org.example.service.Service

import org.example.domain.CreateTraining
import org.example.domain.GetTrainingWithTimestamp
import org.example.proto.AddExerciseReq
import org.example.proto.AddExerciseResp
import org.example.proto.GetTrainingRespOrBuilder
import org.example.proto.RemoveExerciseReq

class Controller(val service: Service) : TrainingsServiceGrpcKt.TrainingsServiceCoroutineImplBase() {
    override suspend fun createTraining(request: CreateTrainingReq): Empty {
        val createTrainingDomain = CreateTraining(
            accountId = request.accountId,
            timestamp = request.timestamp,
            category = request.category,
        )

        request.exercisesList.forEach { exercise ->
            createTrainingDomain.exercises.add(CreateExercise(
                sortId = exercise.sortId,
                exerciseId = exercise.exerciseId,
            ))
        }

        return try {
            service.createTraining(createTrainingDomain)
            Empty.getDefaultInstance()
        } catch (e: Exception) {
            throw io.grpc.StatusException(Status.INTERNAL.withDescription("internal status error: ${e.message}"))
        }
    }

    override suspend fun getTraining(request: GetTrainingReq): GetTrainingResp {
        return try {
            when {
                request.hasRange() -> {
                    val range = request.range
                    val trainings = service.getTrainingsByRange(
                        accountId = request.accountId,
                        from = range.from,
                        to = range.to
                    )

                    if (trainings.isEmpty()) {
                        throw StatusException(Status.NOT_FOUND.withDescription("No trainings found in range"))
                    }

                    val responseBuilder = GetTrainingResp.newBuilder()
                    trainings.forEach { training ->
                        responseBuilder.addTrainings(mapToProtoTraining(training))
                    }
                    responseBuilder.build()
                }

                request.hasTimestamp() -> {
                    val training = service.getTrainingWithTimestamp(
                        accountId = request.accountId,  // ← Добавлен accountId
                        timestamp = request.timestamp
                    ) ?: throw StatusException(Status.NOT_FOUND.withDescription("Training not found"))

                    GetTrainingResp.newBuilder()
                        .addTrainings(mapToProtoTraining(training))
                        .build()
                }

                else -> {
                    throw StatusException(Status.INVALID_ARGUMENT.withDescription("Either timestamp or range must be provided"))
                }
            }
        } catch (e: StatusException) {
            throw e
        } catch (e: Exception) {
            throw StatusException(Status.INTERNAL.withDescription("Internal error: ${e.message}"))
        }
    }

    override suspend fun addExerciseToTraining(request: AddExerciseReq) : AddExerciseResp {
        return try {
            val exercise = AddExerciseToTraining(
                exerciseId = request.exerciseId,
                sortId = request.sortId
            )

            val workoutExerciseId = service.addExerciseToTraining(
                trainingId = request.trainingId,
                exercise = exercise
            )

            AddExerciseResp.newBuilder()
                .setWorkoutExerciseId(workoutExerciseId)
                .build()

        } catch (e: IllegalArgumentException) {
            throw StatusException(Status.INVALID_ARGUMENT.withDescription(e.message))
        } catch (e: Exception) {
            throw StatusException(Status.INTERNAL.withDescription("Internal error: ${e.message}"))
        }
    }

    override suspend fun removeExerciseFromTraining(request: RemoveExerciseReq): Empty {
        return try {
            val removed = service.removeExerciseFromTraining(
                trainingId = request.trainingId,
                workoutExerciseId = request.workoutExerciseId
            )

            if (!removed) {
                throw StatusException(Status.NOT_FOUND.withDescription("Exercise not found in training"))
            }

            Empty.getDefaultInstance()

        } catch (e: StatusException) {
            throw e
        } catch (e: Exception) {
            throw StatusException(Status.INTERNAL.withDescription("Internal error: ${e.message}"))
        }
    }

    private fun mapToProtoTraining(training: GetTrainingWithTimestamp): GetTrainingResp.Training {
        return GetTrainingResp.Training.newBuilder()
            .setId(training.id)
            .setTimestamp(training.timestamp)
            .setCategory(training.category)
            .addAllExercises(
                training.exercises.map { ex ->
                    GetTrainingResp.Exercise.newBuilder()
                        .setId(ex.id)
                        .setSortId(ex.sortId)
                        .setName(ex.name)
                        .setTargetMuscle(ex.targetMuscle)
                        .build()
                }
            )
            .build()
    }
}