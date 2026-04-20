package org.example.repository

import org.example.domain.Exercise

class TrainingsRepository : Repository {
    override suspend fun addExercise(trainingId: Int, exercise: Exercise) {
        TODO("Not yet implemented")
    }
}