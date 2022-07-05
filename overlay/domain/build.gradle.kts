plugins {
    `android-lib`
    `android-base`
    id("kotlin-parcelize")
}

android {
    namespace = "com.splanes.overlay.domain"
}

dependencies {

    api(project(":commons:domain"))
}