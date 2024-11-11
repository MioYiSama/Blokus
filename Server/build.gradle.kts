plugins {
    application
    idea
    kotlin("jvm") version "+"
    id("org.beryx.runtime") version "+"
}

idea.module {
    isDownloadSources = true
    isDownloadJavadoc = true
}

kotlin {
    jvmToolchain(21)
}

group = "top.mioyi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:+")
    implementation("io.ktor:ktor-server-cio:+")
    implementation("io.ktor:ktor-server-websockets:+")

    testImplementation(kotlin("test"))
}

application {
    mainClass.set("top.mioyi.MainKt")
}

runtime {
    addModules("ALL-MODULE-PATH")

    jpackage {
        imageName = "Blokus-Server"
        appVersion = version.toString()
        imageOptions = listOf("--icon", "src/main/resources/icon.ico", "--win-console")
        skipInstaller = true
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}