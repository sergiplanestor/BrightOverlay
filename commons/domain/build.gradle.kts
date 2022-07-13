plugins {
    `android-lib`
    `android-base`
    id("kotlin-parcelize")
}

android {
    namespace = "com.splanes.commons.domain"
}

dependencies {

    api(project(":commons:tools"))
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.21")
}