plugins {
    id("org.springframework.boot")

    kotlin("plugin.jpa")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks {
    bootJar {
        enabled = false
    }

    bootRun {
        enabled = false
    }
}