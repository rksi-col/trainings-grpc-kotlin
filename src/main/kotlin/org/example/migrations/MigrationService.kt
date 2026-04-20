package org.example.org.example.migrations

import org.flywaydb.core.Flyway
import javax.sql.DataSource

class MigrationService(private val dataSource: DataSource) {

    private val flyway: Flyway = Flyway.configure()
        .dataSource(dataSource)
        .locations("classpath:db/migration")
        .baselineOnMigrate(true)
        .cleanDisabled(false)// Если БД не пустая — начать с текущего состояния
        .load()

    fun migrate() {
        val result = flyway.migrate()
        println("Applied ${result.migrationsExecuted} migrations")
        println("Current version: ${result.targetSchemaVersion}")
    }

    fun clean() {
        flyway.clean() // Осторожно! Удаляет ВСЁ из БД
    }

    fun info() {
        flyway.info().all().forEach { info ->
            println("Version: ${info.version}, State: ${info.state}, Script: ${info.script}")
        }
    }

    fun repair() {
        flyway.repair()
    }
}