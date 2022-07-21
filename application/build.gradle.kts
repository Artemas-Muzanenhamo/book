java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    id("org.springframework.boot")

    kotlin("plugin.spring")
}

dependencies {
    api(project(":domain"))
    implementation("org.springframework:spring-context")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.bootJar {
    enabled = false
}

tasks.test {
    useJUnitPlatform()
}

tasks.bootJar {
    enabled = false
}

tasks.bootRun {
    enabled = false
}