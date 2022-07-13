package com.splanes.brightoverlay.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BrightOverlayApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}

const val Notifications = "BRIGHT-OVER.NOTIFICATIONS"
const val Overlay = "BRIGHT-OVER.OVERLAY"