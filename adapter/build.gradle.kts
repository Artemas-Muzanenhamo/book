plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    // module dependencies
    api(project(":application"))

    // spring dependencies
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

    // test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

springBoot {
    mainClass.value("artemas.demo.BookApplicationKt")
}

tasks.bootJar {
    destinationDirectory.set(file(rootProject.buildDir))
}

tasks.test {
    useJUnitPlatform()
}