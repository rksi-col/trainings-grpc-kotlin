package org.example.service

import org.example.domain.AddExerciseToTraining
import org.example.domain.CreateTraining
import org.example.domain.GetTrainingWithTimestamp
import org.example.repository.Repository

interface Service {
    fun createTraining(createTrainingDomain: CreateTraining)
    fun getTrainingWithTimestamp(accountId: Long, timestamp: Long): GetTrainingWithTimestamp
    fun getTrainingsByRange(accountId: Long, from: Long, to: Long): List<GetTrainingWithTimestamp>
    fun addExerciseToTraining(accountId: Long, trainingId: Long, exercise: AddExerciseToTraining)
    fun removeExerciseFromTraining(accountId: Long, trainingId: Long, exerciseId: Long): Boolean
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
        return repository.getTrainingWithTimestamp(accountId, timestamp)
    }

    override fun getTrainingsByRange(accountId: Long, from: Long, to: Long): List<GetTrainingWithTimestamp> {
        return repository.getTrainingsByRange(accountId, from, to)
    }

    override fun addExerciseToTraining(accountId: Long, trainingId: Long, exercise: AddExerciseToTraining) {
        require(exercise.exerciseId > 0) { "Exercise ID must be positive" }
        require(exercise.sortId > 0) { "Sort ID must be positive" }
        repository.addExerciseToTraining(accountId, trainingId, exercise)
    }

    override fun removeExerciseFromTraining(accountId: Long, trainingId: Long, exerciseId: Long): Boolean {
        return repository.removeExerciseFromTraining(accountId, trainingId, exerciseId)
    }
}