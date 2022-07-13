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
    api("com.google.code.gson:gson:2.9.0")
}