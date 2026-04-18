package org.example

import org.example.domain.Exercise
import org.example.migrations.MigrationService
import org.postgresql.ds.PGSimpleDataSource
import javax.sql.DataSource

fun main() {
    val exercise = Exercise(0, "name", "muscle")
    println(exercise)
    val dataSource = createDataSource()
    val migrationService = MigrationService(dataSource)

    migrationService.migrate()
    migrationService.info()
}

fun createDataSource(): DataSource {
    return PGSimpleDataSource().apply {
        setURL("jdbc:postgresql://localhost:5432/postgres")
        user = "postgres"
        password = "postgres"
    }
}