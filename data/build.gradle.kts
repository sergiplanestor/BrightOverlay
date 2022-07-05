plugins {
    `android-lib`
    `android-base`
}

android {
    namespace = "com.splanes.brightoverlay.data"
}

dependencies {
    implementation(project(":domain"))
}
