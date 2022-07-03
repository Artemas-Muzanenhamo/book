plugins {
    kotlin("jvm")  version "1.6.21"
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.6.21"
}

group = "artemas.demo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    // module dependencies
    api(project(":application"))
    api(project(":domain"))

    // spring dependencies
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

springBoot {
    mainClass.value("artemas.demo.BookApplicationKt")
}