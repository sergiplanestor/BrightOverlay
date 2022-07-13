package com.splanes.overlay.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import com.splanes.commons.domain.model.orNull
import com.splanes.commons.ui.viewmodel.BaseViewModel
import com.splanes.commons.ui.viewmodel.launch
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.service.OverlayWindowService
import com.splanes.overlay.domain.usecase.FindLastStateUseCase
import com.splanes.overlay.domain.usecase.UpdateEnableStateUseCase
import com.splanes.overlay.domain.usecase.UpdateStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/*
 * Created on 10/07/2022 at 12:48
 * @author Sergi Planes
 * @since 1.0.0
 */

@HiltViewModel
class OverlaySettingsViewModel @Inject constructor(
    private val findLastStateUseCase: FindLastStateUseCase,
    private val enableUseCase: UpdateEnableStateUseCase,
    private val updateStateUseCase: UpdateStateUseCase,
) : BaseViewModel() {

    private val mutableOverlayState: MutableStateFlow<OverlayState> = MutableStateFlow(OverlayState())
    private val mutableEnableState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private lateinit var mutablePermissionState: MutableStateFlow<Boolean>
    private val isEnabled: Boolean get() = mutableEnableState.value
    private var overlayService: OverlayWindowService? = null

    val overlayState: StateFlow<OverlayState> get() = mutableOverlayState
    val enableState: StateFlow<Boolean> get() = mutableEnableState

    init {
        restorePreviousState()
    }

    private fun restorePreviousState() =
        launch {
            findLastStateUseCase().handleOnUi {
                orNull()?.let { mutableOverlayState.value = it }
            }
        }

    fun updateSettings(updater: OverlayState.() -> OverlayState) {
        val state = updater(overlayState.value)
        mutableOverlayState.value = state
        when {
            isEnabled -> launch { updateStateUseCase(overlayService!!, state) }
            !mutablePermissionState.value -> toast("State couldn't be updated. Permissions required.")
        }
    }

    fun start() {
        updateEnableState(enable = true)
    }

    fun stop() {
        updateEnableState(enable = false)
    }

    private fun updateEnableState(enable: Boolean) {
        launch {
            enableUseCase(overlayService!!, enable).handleOnUi {
                mutableEnableState.value = enable
                if (enable) updateSettings { this }
            }
        }
    }

    fun permissionState(initial: Boolean): StateFlow<Boolean> =
        MutableStateFlow(initial).also { mutablePermissionState = it }

    fun onPermissionResult(context: Context) {
        mutablePermissionState.value = context.isPermissionGranted()
    }

    fun onServiceConnected(service: OverlayWindowService) {
        overlayService = service
    }
}

fun ManagedActivityResultLauncher<Intent, ActivityResult>.launchOverlayRequest(context: Context) =
    launch(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${context.packageName}")))

fun Context.isPermissionGranted() = Settings.canDrawOverlays(this)