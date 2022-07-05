plugins {
    `android-lib`
    `android-base`
}

android {
    namespace = "com.splanes.overlay.data"
}

dependencies {
    implementation(project(":commons:data"))
    implementation(project(":overlay:domain"))
}