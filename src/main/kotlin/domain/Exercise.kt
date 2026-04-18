package org.example.domain

data class Exercise(
    val id: Int,
    val name: String,
    val targetMuscle: String,
)

data class PerformedExercises(
    val id: Int,
    val trainingId: Int,
    val exerciseId: Int,
    val sortId: Int,
)

data class Training(
    val id: Int,
    val timestamp: Long,
    val category: String,
)

//-- Конкретное выполнение
//CREATE TABLE performed_exercises (
//    id BIGSERIAL PRIMARY KEY,
//    workout_id BIGINT NOT NULL,
//    exercise_id INT NOT NULL REFERENCES exercises(id),
//    sort_order SMALLINT NOT NULL,
//    actual_target_muscle VARCHAR(50), -- NULL = берём из шаблона
//    notes TEXT
//);