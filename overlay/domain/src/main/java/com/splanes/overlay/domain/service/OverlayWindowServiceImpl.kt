package com.splanes.overlay.domain.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.ColorDrawable
import android.hardware.display.DisplayManager
import android.os.Build
import android.os.IBinder
import android.view.Display
import android.view.Gravity
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.FrameLayout
import com.splanes.overlay.domain.model.OverlayState
import javax.inject.Inject
import timber.log.Timber

/*
 * Created on 10/07/2022 at 13:30
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayWindowServiceImpl : Service(), OverlayWindowService {

    private val binder by lazy { OverlayWindowServiceBinder(service = this) }
    private val view by lazy { FrameLayout(viewOverlayContext()) }
    private var isViewAttached: Boolean = false

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onCreate() {
        super.onCreate()
        Timber.v("OverlayWindowService created")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("OverlayWindowService destroyed")
    }

    override fun show() {
        if (!isViewAttached) {
            windowManager.addView(view)
            isViewAttached = true
        }
    }

    override fun hide() {
        if (isViewAttached) {
            windowManager.removeViewImmediate(view)
            isViewAttached = false
        }
    }

    override fun updateOverlayState(state: OverlayState) {
        if (isViewAttached) {
            view.applyState(state)
        } else {
            show()
            updateOverlayState(state)
        }
    }
}

internal val Service.windowManager: WindowManager get() = getSystemService(WindowManager::class.java)

internal fun Service.viewOverlayContext(): Context =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        createWindowContext(
            getSystemService(DisplayManager::class.java).getDisplay(Display.DEFAULT_DISPLAY),
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            null
        )
    } else {
        this
    }

internal fun WindowManager.addView(view: View) {
    addView(
        view,
        WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            PixelFormat.TRANSLUCENT
        )
    )
}
internal fun View.applyState(overlayState: OverlayState) {
    setBackgroundColor(Color.toArgb(overlayState.color.value))
    alpha = overlayState.opacity.alpha
}