plugins {
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    //kapt += "com.google.dagger:hilt-android-compiler:2.42"
    add("kapt", "com.google.dagger:hilt-android-compiler:2.40.5")
    api += "com.google.dagger:hilt-android:2.40.5"
    api += "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    api += "androidx.hilt:hilt-navigation-compose:1.0.0"
    api += "androidx.core:core-ktx:1.8.0"
    api += "com.jakewharton.timber:timber:5.0.1"
    api += "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2"
    api += "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2"

    kapt += "org.projectlombok:lombok:1.18.24"

    unitTest += "junit:junit:4.13.2"
    integrationTest += "androidx.test.ext:junit:1.1.3"
    integrationTest += "androidx.test.espresso:espresso-core:3.4.0"
}
