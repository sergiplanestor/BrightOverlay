plugins {
    `android-lib`
    `android-base`
    id("kotlin-parcelize")
}

android {
    namespace = "com.splanes.commons.data"
}

dependencies {
    implementation(project(":commons:domain"))
}