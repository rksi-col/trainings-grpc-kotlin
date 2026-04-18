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
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.flywaydb:flyway-core:12.4.0")
    implementation("org.flywaydb:flyway-database-postgresql:12.4.0")
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