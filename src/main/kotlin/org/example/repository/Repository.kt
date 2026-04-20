package org.example.repository

import org.example.domain.Exercise

interface Repository {
    suspend fun addExercise(trainingId: Int, exercise: Exercise)
}
