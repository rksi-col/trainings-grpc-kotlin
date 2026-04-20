package org.example
import io.grpc.Server
import io.grpc.ServerBuilder
import org.example.controller.Controller
import org.example.domain.Exercise
import org.example.org.example.migrations.MigrationService
import org.example.proto.GreeterGrpcKt
import org.example.proto.HelloReply

import org.example.proto.HelloRequest
import org.example.repository.TrainingsRepository
import org.example.service.TrainingsService

import org.postgresql.ds.PGSimpleDataSource
import javax.sql.DataSource

class Impl : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder().setMessage("Hello ${request.name}").build()
    }
}

fun main() {
    val exercise = Exercise(0, "name", "muscle")
    println(exercise)
    val dataSource = createDataSource()
    val migrationService = MigrationService(dataSource)



//    migrationService.clean()
    migrationService.migrate()
//    migrationService.info()

//    val trainingsRepository = TrainingsRepository()
//    val trainingsService = TrainingsService(trainingsRepository)
//    val trainingsController = Controller(trainingsService)

    val trainingsController = Controller(
        TrainingsService(
            TrainingsRepository()
        )
    )

    val server: Server = ServerBuilder
        .forPort(50051)
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