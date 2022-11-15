plugins {
    id("org.springframework.boot")
}

dependencies {
    // module dependencies
    testImplementation(project(":adapter"))

    // test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks {
    bootJar {
        enabled = false
    }

    bootRun {
        enabled = false
    }
}
