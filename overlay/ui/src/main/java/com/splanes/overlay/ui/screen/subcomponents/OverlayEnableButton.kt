package com.splanes.overlay.ui.screen.subcomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.splanes.commons.ui.resources.stringOf
import com.splanes.commons.ui.theme.bodyStyle
import com.splanes.commons.ui.theme.titleStyle
import com.splanes.overlay.ui.R
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors

/*
 * Created on 13/07/2022 at 0:45
 * @author Sergi Planes
 * @since 1.0.0
 */

@Composable
fun OverlayEnableButton(
    overlayEnabled: Boolean,
    enabled: Boolean,
    onChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onChange(!overlayEnabled) },
            enabled = enabled,
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Colors.primary,
                contentColor = Colors.onPrimary
            ),
        ) {
            Text(
                text = stringOf { if (overlayEnabled) R.string.overlay_settings_layer_hide else R.string.overlay_settings_layer_show },
                style = titleStyle(),
                color = Colors.onPrimary
            )
        }
        AnimatedVisibility(visible = !enabled) {
            Text(
                text = stringOf { R.string.overlay_settings_permissions_denied_reason },
                style = bodyStyle()
            )
        }
    }
}

@Composable
@Preview(name = "Light", group = "OverlayEnableButton", showSystemUi = true,
         uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
private fun OverlayEnableButtonLightPreview() {
    UiTheme.AppTheme {
        var enabled by remember { mutableStateOf(false) }
        OverlayEnableButton(
            overlayEnabled = enabled,
            enabled = true
        ) { enabled = it }
    }
}

@Composable
@Preview(
    name = "Dark", group = "OverlayEnableButton", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun OverlayEnableButtonDarkPreview() {
    UiTheme.AppTheme {
        var enabled by remember { mutableStateOf(false) }
        OverlayEnableButton(
            overlayEnabled = enabled,
            enabled = true
        ) { enabled = it }
    }
}