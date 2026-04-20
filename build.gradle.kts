plugins {
    kotlin("jvm") version "2.2.0"
    application
}



group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Source: https://mvnrepository.com/artifact/com.google.protobuf/protobuf-bom
    implementation(platform("com.google.protobuf:protobuf-bom:4.34.1"))
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.flywaydb:flyway-core:12.4.0")
    implementation("org.flywaydb:flyway-database-postgresql:12.4.0")
//    implementation("com.google.protobuf:protobuf-kotlin:30.2")
    implementation("io.grpc:grpc-kotlin-stub:1.5.0")
    implementation("io.grpc:grpc-protobuf:1.5.0")

    // Protobuf для Kotlin
    implementation("com.google.protobuf:protobuf-kotlin:3.25.3")

    // gRPC для Kotlin
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
    implementation("io.grpc:grpc-netty-shaded:1.60.1")
    implementation("io.grpc:grpc-protobuf:1.60.1")
    implementation("io.grpc:grpc-stub:1.60.1")

    // Source: https://mvnrepository.com/artifact/com.google.protobuf/protobuf-kotlin
    implementation("com.google.protobuf:protobuf-kotlin:4.34.1")

    // Kotlin coroutines (нужны для gRPC)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

    // Аннотации (для @Generated)
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

application {
    // Укажи свой главный класс
    mainClass.set("org.example.MainKt")
}

sourceSets {
    main {
        kotlin {
            srcDir("src/main/java")  // ← Важно!
        }
    }
}