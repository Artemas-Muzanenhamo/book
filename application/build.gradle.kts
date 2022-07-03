plugins {
    kotlin("jvm")
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    api(project(":domain"))
}