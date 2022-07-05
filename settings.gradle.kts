@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "7.4.0-alpha05"
        id("com.android.library") version "7.4.0-alpha05"
        id("kotlin-android") version "1.7.0"
        id("kotlin-kapt") version "1.7.0"
        id("dagger.hilt.android.plugin")
        id("kotlin-parcelize")
        id("org.jlleitschuh.gradle.ktlint")
        id("org.jetbrains.kotlin.android") version "1.7.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BrightOverlay"
include(
    ":app",
    ":commons:tools",
    ":commons:data",
    ":commons:domain",
    ":commons:ui",
    ":overlay:data",
    ":overlay:domain",
    ":overlay:ui",
    ":data",
    ":ui",
    ":domain",
)
