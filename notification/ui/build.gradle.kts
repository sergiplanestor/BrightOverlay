plugins {
    `android-lib`
    `android-base`
}

android {
    namespace = "com.splanes.notification.ui"
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.2.0-rc01" }
}

dependencies {

    implementation(project(":commons:ui"))
    implementation("com.github.sergiplanestor.toolkit:theme:1.1.0-CBA")


    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")


    implementation("com.google.accompanist:accompanist-navigation-animation:0.24.2-alpha")
    implementation("com.google.accompanist:accompanist-pager:0.24.7-alpha")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.24.1-alpha")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}