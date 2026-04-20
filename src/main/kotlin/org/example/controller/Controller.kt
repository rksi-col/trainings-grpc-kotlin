package org.example.controller

import org.example.proto.GreeterGrpcKt
import org.example.proto.HelloReply
import org.example.proto.HelloRequest
import org.example.service.Service

class Controller(service: Service) : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return super.sayHello(request)
    }
}