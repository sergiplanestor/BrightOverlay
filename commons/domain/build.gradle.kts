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

    implementation(kotlin("reflect"))
}