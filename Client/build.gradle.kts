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
    // Graphics
    implementation("uk.co.electronstudio.jaylib:jaylib:+")

    // Networking
    implementation("io.ktor:ktor-client-core:+")
    implementation("io.ktor:ktor-client-cio:+")
    implementation("io.ktor:ktor-client-websockets:+")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:+")

    testImplementation(kotlin("test"))
}

application {
    mainClass.set("top.mioyi.MainKt")
}

runtime {
    addModules("ALL-MODULE-PATH")

    jpackage {
        imageName = "Blokus-Client"
        appVersion = version.toString()
        imageOptions = listOf("--icon", "src/main/resources/images/icons/icon.ico")
        skipInstaller = true

        jvmArgs = listOf(
            "-XX:+UseZGC",
            "-XX:+ZGenerational",
            "-Xmx256M",
            "-Dfile.encoding=UTF-8"
        )
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}