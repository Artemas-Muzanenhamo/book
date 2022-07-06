plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

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