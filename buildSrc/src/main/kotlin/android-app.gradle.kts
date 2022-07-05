import org.gradle.api.JavaVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.splanes.brightoverlay"
        minSdk = 28
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    allprojects { println(name) }
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":ui"))
}
