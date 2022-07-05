plugins {
    `android-lib`
    `android-base`
}

android {
    namespace = "com.splanes.overlay.ui"
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.1.0-rc03" }
}

dependencies {

    implementation(project(":overlay:domain"))
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    implementation("androidx.compose.material:material:1.2.0-rc02")
    implementation("androidx.compose.material3:material3:1.0.0-alpha13")
    implementation("androidx.compose.material:material-icons-extended:1.2.0-rc02")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.0-rc02")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.5.0-rc02")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.24.2-alpha")
    implementation("com.google.accompanist:accompanist-pager:0.24.7-alpha")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-rc02")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.24.1-alpha")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}