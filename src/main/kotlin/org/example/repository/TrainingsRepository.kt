package org.example.repository

import org.example.domain.AddExerciseToTraining
import org.example.domain.CreateTraining
import org.example.domain.GetExercise
import java.sql.Timestamp
import javax.sql.DataSource

import org.example.domain.GetTrainingWithTimestamp
import java.time.Instant

interface Repository {
    fun createTraining(createTrainingDomain: CreateTraining)
    fun getTrainingWithTimestamp(accountId: Long, timestamp: Long): GetTrainingWithTimestamp
    fun getTrainingsByRange(accountId: Long, from: Long, to: Long): List<GetTrainingWithTimestamp>
    fun addExerciseToTraining(accountId: Long, trainingId: Long, exercise: AddExerciseToTraining)
    fun removeExerciseFromTraining(accountId: Long, trainingId: Long, workoutExerciseId: Long): Boolean
}

class TrainingsRepository(val dataSource: DataSource) : Repository {
    override fun createTraining(createTrainingDomain: CreateTraining) {
        dataSource.connection.use { connection ->
            connection.autoCommit = false

            try {
                val trainingId = connection.prepareStatement(
                    """
                        INSERT INTO trainings (_timestamp, category, account_id)
                        VALUES (?, ?, ?)
                        RETURNING id
                    """.trimIndent()
                ).use { preparedStatement ->
                    preparedStatement.setTimestamp(1, Timestamp(createTrainingDomain.timestamp))
                    preparedStatement.setString(2, createTrainingDomain.category)
                    preparedStatement.setLong(3, createTrainingDomain.accountId)
                    preparedStatement.executeQuery().use { result ->
                        if (result.next()) result.getLong(1)
                        else throw IllegalStateException("could not insert training")
                    }
                }

                if (createTrainingDomain.exercises.isNotEmpty()) {
                    val placeholders = createTrainingDomain.exercises.joinToString(", ") { "(?, ?, ?)" }

                    connection.prepareStatement(
                        """
                    INSERT INTO workout_exercises (training_id, exercise_id, sort_id)
                    VALUES $placeholders
                    """.trimIndent()
                    ).use { stmt ->
                        var idx = 1
                        createTrainingDomain.exercises.forEach { ex ->
                            stmt.setLong(idx++, trainingId)
                            stmt.setLong(idx++, ex.exerciseId)
                            stmt.setLong(idx++, ex.sortId)
                        }
                        stmt.executeUpdate()
                    }
                }

                connection.commit()

            } catch (e: Exception) {
                connection.rollback()
                throw Exception("create training: ${e.message}")
            } finally {
                connection.autoCommit = true
            }

        }
    }
    override fun getTrainingsByRange(accountId: Long, from: Long, to: Long): List<GetTrainingWithTimestamp> {
        dataSource.connection.use { conn ->
            val sql = """
            SELECT 
                t.id as training_id,
                t._timestamp,
                t.category,
                t.account_id,
                we.id as performed_id,
                we.sort_id,
                e.id as exercise_id,
                e.name,
                e.target_muscle
            FROM trainings t
        LEFT JOIN workout_exercises we ON t.id = we.training_id
        LEFT JOIN exercises e ON we.exercise_id = e.id
        WHERE t.account_id = ? AND t._timestamp >= ? AND t._timestamp <= ?
        ORDER BY t._timestamp DESC, we.sort_id
        """.trimIndent()

            conn.prepareStatement(sql).use { stmt ->
                stmt.setLong(1, accountId)  // fильтр по пользователю
                stmt.setTimestamp(2, Timestamp.from(Instant.ofEpochMilli(from)))
                stmt.setTimestamp(3, Timestamp.from(Instant.ofEpochMilli(to)))
                stmt.executeQuery().use { rs ->
                    val trainingsMap = mutableMapOf<Long, GetTrainingWithTimestamp>()
                    val trainingsOrder = mutableListOf<GetTrainingWithTimestamp>()

                    while (rs.next()) {
                        val trainingId = rs.getLong("training_id")
                        var training = trainingsMap[trainingId]

                        if (training == null) {
                            training = GetTrainingWithTimestamp(
                                id = trainingId,
                                accountId = rs.getLong("account_id"),
                                timestamp = rs.getTimestamp("_timestamp").time,
                                category = rs.getString("category")
                            )
                            trainingsMap[trainingId] = training
                            trainingsOrder.add(training)
                        }

                        val exerciseId = rs.getLong("exercise_id")
                        if (!rs.wasNull()) {
                            training.exercises.add(
                                GetExercise(
                                    id = exerciseId,
                                    sortId = rs.getLong("sort_id"),
                                    name = rs.getString("name"),
                                    targetMuscle = rs.getString("target_muscle")
                                )
                            )
                        }
                    }

                    return trainingsOrder
                }
            }
        }
    }

    override fun addExerciseToTraining(accountId: Long, trainingId: Long, exercise: AddExerciseToTraining) {
        dataSource.connection.use { conn ->
            val checkSql = "SELECT 1 FROM trainings WHERE id = ? AND account_id = ?"
            conn.prepareStatement(checkSql).use { stmt ->
                stmt.setLong(1, trainingId)
                stmt.setLong(2, accountId)
                stmt.executeQuery().use { rs ->
                    if (!rs.next()) {
                        throw IllegalStateException("Training does not belong to user")
                    }
                }
            }

            val sql = """
            INSERT INTO workout_exercises (training_id, exercise_id, sort_id)
            VALUES (?, ?, ?)
            RETURNING id
        """.trimIndent()

            conn.prepareStatement(sql).use { stmt ->
                stmt.setLong(1, trainingId)
                stmt.setLong(2, exercise.exerciseId)
                stmt.setLong(3, exercise.sortId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) rs.getLong(1)
                    else throw IllegalStateException("Failed to add exercise")
                }
            }
        }
    }


    override fun removeExerciseFromTraining(
        accountId: Long,
        trainingId: Long,
        exerciseId: Long
    ): Boolean {
        dataSource.connection.use { conn ->
            val sql = """
            DELETE FROM workout_exercises
            USING trainings t
            WHERE workout_exercises.training_id = ?
              AND workout_exercises.exercise_id = ?   
              AND workout_exercises.training_id = t.id
              AND t.account_id = ?
        """.trimIndent()

            conn.prepareStatement(sql).use { stmt ->
                stmt.setLong(1, trainingId)
                stmt.setLong(2, exerciseId)
                stmt.setLong(3, accountId)
                return stmt.executeUpdate() > 0
            }
        }
    }

    override fun getTrainingWithTimestamp(accountId: Long, timestamp: Long): GetTrainingWithTimestamp {
        dataSource.connection.use { conn ->
            val sql = """
            SELECT 
                t.id as training_id,
                t._timestamp,
                t.category,
                pe.id as performed_id,
                pe.sort_id,
                e.id as exercise_id,
                e.name,
                e.target_muscle
            FROM trainings t
            LEFT JOIN workout_exercises pe ON t.id = pe.training_id
            LEFT JOIN exercises e ON pe.exercise_id = e.id
            WHERE t.account_id = ? AND t._timestamp = ?   -- ← Добавили account_id
            ORDER BY pe.sort_id
        """.trimIndent()

            conn.prepareStatement(sql).use { stmt ->
                stmt.setLong(1, accountId)
                stmt.setTimestamp(2, Timestamp(timestamp))
                stmt.executeQuery().use { rs ->
                    var training: GetTrainingWithTimestamp? = null

                    while (rs.next()) {
                        if (training == null) {
                            training = GetTrainingWithTimestamp(
                                id = rs.getLong("training_id"),
                                accountId = rs.getLong("account_id"),
                                timestamp = rs.getTimestamp("_timestamp").time,
                                category = rs.getString("category")
                            )
                        }

                        val exerciseId = rs.getLong("exercise_id")
                        if (!rs.wasNull()) {
                            training.exercises.add(
                                GetExercise(
                                    id = exerciseId,
                                    sortId = rs.getLong("sort_id"),
                                    name = rs.getString("name"),
                                    targetMuscle = rs.getString("target_muscle")
                                )
                            )
                        }
                    }

                    return training ?: throw IllegalStateException("No training with timestamp: $timestamp")
                }
            }
        }
    }
}