package org.example.service

import org.example.domain.Exercise
import org.example.repository.Repository

class TrainingsService(repository: Repository) : Service {
    override suspend fun addExercise(trainingId: Int, exercise: Exercise) {
        TODO("Not yet implemented")
    }
}