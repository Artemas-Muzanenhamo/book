java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":domain"))
}