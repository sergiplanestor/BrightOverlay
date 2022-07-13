package com.splanes.overlay.ui.screen

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.splanes.commons.ui.component.spacer.column.Divider
import com.splanes.commons.ui.component.spacer.column.Spacer
import com.splanes.commons.ui.component.spacer.column.Weight
import com.splanes.commons.ui.resources.stringOf
import com.splanes.commons.ui.theme.headlineStyle
import com.splanes.commons.ui.theme.titleStyle
import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.extensions.of
import com.splanes.overlay.domain.model.of
import com.splanes.overlay.domain.service.OverlayWindowServiceBinder
import com.splanes.overlay.domain.service.OverlayWindowServiceImpl
import com.splanes.overlay.ui.OverlaySettingsViewModel
import com.splanes.overlay.ui.isPermissionGranted
import com.splanes.overlay.ui.launchOverlayRequest
import com.splanes.overlay.ui.screen.subcomponents.OverlayAlphaSettings
import com.splanes.overlay.ui.screen.subcomponents.OverlayColorSettings
import com.splanes.overlay.ui.screen.subcomponents.OverlayEnableButton
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.utils.UiSideEffect
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors
import timber.log.Timber
import com.splanes.overlay.ui.R.string as Strings

/*
 * Created on 10/07/2022 at 3:27
 * @author Sergi Planes
 * @since 1.0.0
 */


@Composable
fun OverlaySettings(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val viewModel = hiltViewModel<OverlaySettingsViewModel>()
    val overlayState by viewModel.overlayState.collectAsState()
    val isOverlayEnabled by viewModel.enableState.collectAsState()
    val isPermissionGranted by viewModel.permissionState(context.isPermissionGranted()).collectAsState()
    val toastStateFlow = viewModel.toastStateFlow
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { viewModel.onPermissionResult(context) }
    )

    LaunchedEffect(true) {
        if (!isPermissionGranted) launcher.launchOverlayRequest(context)
    }

    UiSideEffect(toastStateFlow) {
        Toast.makeText(context, message, duration).show()
    }

    if (isPermissionGranted) {
        LaunchedEffect(true) {
            val intent = Intent(context, OverlayWindowServiceImpl::class.java)
            val connector = object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                   Timber.d("OverlayWindowService Connected")
                    (service as? OverlayWindowServiceBinder)?.service?.let {
                        viewModel.onServiceConnected(it)
                    }
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    Timber.d("OverlayWindowService Disconnected")
                }
            }
            context.bindService(intent, connector, ComponentActivity.BIND_AUTO_CREATE or ComponentActivity.BIND_IMPORTANT)
        }
    }

    Column(
        modifier = modifier
            //.verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(height = 4)
        Text(
            text = stringOf { Strings.overlay_settings_title },
            style = headlineStyle { small },
            color = Colors.secondary
        )
        Spacer(height = 6)
        Divider(modifier = Modifier, alpha = .4)
        Weight(.5)
        OverlayColorSettings(
            color = Color(overlayState.color.value),
            onChange = { c -> viewModel.updateSettings { copy(color = OverlayColor.of(c.value.toLong())) } }
        )
        Weight(.5)
        OverlayAlphaSettings(
            alpha = overlayState.opacity.alpha,
            onChange = { a -> viewModel.updateSettings { copy(opacity = OverlayOpacity.of(a)) } }
        )
        Weight(.5)
        OverlayEnableButton(
            overlayEnabled = isOverlayEnabled,
            enabled = Settings.canDrawOverlays(LocalContext.current),
            onChange = { enable -> viewModel.run { if (enable) start() else stop() } }
        )
        Crossfade(targetState = isPermissionGranted) { isGranted ->
            if (!isGranted) {
                Spacer(height = 16)
                OutlinedButton(onClick = { launcher.launchOverlayRequest(context) }) {
                    Text(
                        text = stringOf { Strings.overlay_settings_req_permission },
                        style = titleStyle { small },
                    )
                }
            }
        }
        Weight(.45)
    }
}

