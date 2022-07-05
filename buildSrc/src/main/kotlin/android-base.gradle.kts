plugins {
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    kapt += "com.google.dagger:hilt-android-compiler:2.40.5"
    impl += "com.google.dagger:hilt-android:2.40.5"
    impl += "androidx.core:core-ktx:1.8.0"
    impl += "com.jakewharton.timber:timber:5.0.1"
    impl += "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2"
    impl += "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2"
    add("implementation", platform("io.arrow-kt:arrow-stack:1.0.1"))

    impl += "io.arrow-kt:arrow-core"
    impl += "io.arrow-kt:arrow-fx-coroutines"

    unitTest += "junit:junit:4.13.2"
    integrationTest += "androidx.test.ext:junit:1.1.3"
    integrationTest += "androidx.test.espresso:espresso-core:3.4.0"
}
