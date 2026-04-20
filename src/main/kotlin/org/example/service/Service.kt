package org.example.service

import org.example.domain.Exercise

interface Service {
    suspend fun addExercise(trainingId: Int, exercise: Exercise)
}