plugins {
    `android-app`
    `android-base`
}

android {
    namespace = "com.splanes.brightoverlay"
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.2.0-rc01" }
}

dependencies {

    implementation(project(":overlay:data"))
    implementation(project(":overlay:domain"))
    implementation(project(":overlay:ui"))
    implementation(project(":notification:ui"))
    implementation(project(":commons:tools"))
    implementation(project(":commons:ui"))
}
