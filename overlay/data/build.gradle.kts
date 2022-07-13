plugins {
    `android-lib`
    `android-base`
    id("kotlin-parcelize")
}

android {
    namespace = "com.splanes.overlay.data"
}

dependencies {
    implementation(project(":commons:data"))
    implementation(project(":overlay:domain"))
}