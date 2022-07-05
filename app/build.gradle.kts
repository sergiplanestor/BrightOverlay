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
}

dependencies {

    // kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    // implementation("androidx.core:core-ktx:1.8.0")
    // implementation("com.jakewharton.timber:timber:5.0.1")
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")

    // testImplementation("junit:junit:4.13.2")
    // androidTestImplementation("androidx.test.ext:junit:1.1.3")
    // androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
