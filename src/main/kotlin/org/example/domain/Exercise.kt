package org.example.domain

import org.example.proto.GetTrainingResp

// ============== памятка о бд==============

//data class Exercise(
//    val id: Int,
//    val name: String,
//    val targetMuscle: String,
//)
//
//data class PerformedExercises(
//    val id: Int,
//    val trainingId: Int,
//    val exerciseId: Int,
//    val sortId: Int,
//)
//
//data class Training(
//    val id: Int,
//    val timestamp: Long,
//    val category: String,
//)


// ============================================

data class CreateExercise (
    val sortId: Long,
    val exerciseId: Long,
)

data class CreateTraining(
    val accountId: Long,
    val timestamp: Long,
    val category: String,
    var exercises: MutableList<CreateExercise> = mutableListOf(),
)

data class GetExercise(
    val id: Long,
    val sortId: Long,
    val name: String,
    val targetMuscle: String,
)

data class GetTrainingWithTimestamp(
    val accountId: Long,
    var id: Long = -1,
    var timestamp: Long = -1,
    val category: String = "",
    val exercises: MutableList<GetExercise> = mutableListOf(),
    )

data class AddExerciseToTraining(
    val exerciseId: Long,
    val sortId: Long,
)