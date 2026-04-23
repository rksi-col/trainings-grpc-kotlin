package org.example
import io.grpc.Server
import io.grpc.ServerBuilder
import org.example.controller.Controller

import org.example.org.example.migrations.MigrationService
import org.example.proto.TrainingsServiceGrpc

import org.example.repository.TrainingsRepository
import org.example.service.TrainingsService

import org.postgresql.ds.PGSimpleDataSource
import javax.sql.DataSource

fun main() {
    // migration
    val dataSource = createDataSource()
    val migrationService = MigrationService(dataSource)
//    migrationService.clean()
    migrationService.migrate()
//    migrationService.info()

    val trainingsController = Controller(
        TrainingsService(
            TrainingsRepository(dataSource),
        )
    )
    val serviceDescriptor = TrainingsServiceGrpc.getServiceDescriptor()
    println("📋 Методы сервиса:")
    serviceDescriptor.methods.forEach { method ->
        println("   - ${method.fullMethodName}")
    }

    val server: Server = ServerBuilder
        .forPort(50055)
        .addService(trainingsController)
        .build()

    server.start()

    println("Server started on port 50051")

    server.awaitTermination()



}

fun createDataSource(): DataSource {
    return PGSimpleDataSource().apply {
        setURL("jdbc:postgresql://localhost:5432/postgres")
        user = "postgres"
        password = "postgres"
    }
}