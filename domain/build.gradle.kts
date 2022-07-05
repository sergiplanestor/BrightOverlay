plugins {
    `android-lib`
    `android-base`
    id("kotlin-parcelize")
}

android {
    namespace = "com.splanes.brightoverlay.domain"
}

dependencies {

    api(project(":commons:domain"))

    implementation(kotlin("reflect"))
}
