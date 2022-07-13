plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    // android gradle plugin, required by custom plugin
    implementation("com.android.tools.build:gradle:7.3.0-beta04")

    // kotlin plugin, required by custom plugin
    implementation(kotlin("gradle-plugin", "1.6.21"))

    //
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:9.2.1")
}
