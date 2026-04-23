package org.example.service

import org.example.domain.AddExerciseToTraining
import org.example.domain.CreateTraining
import org.example.domain.GetTrainingWithTimestamp
import org.example.repository.Repository

interface Service {
    fun createTraining(createTrainingDomain: CreateTraining)
    fun getTrainingWithTimestamp(accountId: Long, timestamp: Long): GetTrainingWithTimestamp
    fun getTrainingsByRange(accountId: Long, from: Long, to: Long): List<GetTrainingWithTimestamp>
    fun addExerciseToTraining(trainingId: Long, exercise: AddExerciseToTraining): Long
    fun removeExerciseFromTraining(trainingId: Long, workoutExerciseId: Long): Boolean
}

class TrainingsService(val repository: Repository) : Service {
    override fun createTraining(createTrainingDomain: CreateTraining) {
        try {
            repository.createTraining(createTrainingDomain)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getTrainingWithTimestamp(accountId: Long, timestamp: Long): GetTrainingWithTimestamp {
        try {
            return repository.getTrainingWithTimestamp(accountId, timestamp)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getTrainingsByRange(accountId: Long, from: Long, to: Long): List<GetTrainingWithTimestamp> {
        try {
            return repository.getTrainingsByRange(accountId, from, to)
        } catch (e: Exception) {
            throw e
        }
    }

   override fun addExerciseToTraining(trainingId: Long, exercise: AddExerciseToTraining): Long {
        require(exercise.exerciseId > 0) { "Exercise ID must be positive" }
        require(exercise.sortId > 0) { "Sort ID must be positive" }
        return repository.addExerciseToTraining(trainingId, exercise)
    }

    override fun removeExerciseFromTraining(trainingId: Long, workoutExerciseId: Long): Boolean {
        return repository.removeExerciseFromTraining(trainingId, workoutExerciseId)
    }
}