package com.splanes.overlay.ui.screen.subcomponents

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.splanes.commons.ui.component.spacer.column.Spacer
import com.splanes.commons.ui.component.spacer.row.Spacer
import com.splanes.commons.ui.component.spacer.row.Weight
import com.splanes.commons.ui.resources.minus
import com.splanes.commons.ui.resources.plus
import com.splanes.commons.ui.resources.stringOf
import com.splanes.commons.ui.theme.headlineStyle
import com.splanes.commons.ui.theme.titleStyle
import com.splanes.overlay.ui.R
import com.splanes.toolkit.compose.ui.components.common.utils.color.alpha
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors

/*
 * Created on 13/07/2022 at 0:42
 * @author Sergi Planes
 * @since 1.0.0
 */


@Composable
fun OverlayAlphaSettings(alpha: Float, onChange: (Float) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(size = 12.dp),
        elevation = 4.dp,
        color = Colors.tertiary.alpha(.5).compositeOver(Colors.background)
    ) {
        var isSliderPressed by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 12.dp)
        ) {
            Text(
                text = stringOf { R.string.overlay_settings_layer_alpha },
                style = titleStyle { large }.run { copy(fontSize = fontSize + 2.sp) }
            )
            Spacer(height = 16)
            val thumbColor by animateColorAsState(
                targetValue = if (isSliderPressed) {
                    Colors.secondary.alpha(.8)
                } else {
                    Colors.primary
                },
                animationSpec = tween(durationMillis = 300)
            )
            val trackColor by animateColorAsState(
                targetValue = if (isSliderPressed) {
                    Colors.secondary.alpha(.3)
                } else {
                    Colors.primary.alpha(.3)
                },
                animationSpec = tween(durationMillis = 300)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(width = 4)
                Text(text = ".1", style = titleStyle().run { copy(fontSize = fontSize - 1.sp) })
                Slider(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f),
                    value = alpha,
                    valueRange = 0.1f..0.9f,
                    colors = SliderDefaults.colors(
                        thumbColor = thumbColor,
                        activeTrackColor = Colors.primary.alpha(.75),
                        inactiveTrackColor = trackColor
                    ),
                    onValueChange = { a ->
                        isSliderPressed = true
                        onChange(a)
                    },
                    onValueChangeFinished = { isSliderPressed = false }
                )
                Text(text = ".9", style = titleStyle().run { copy(fontSize = fontSize - 1.sp) })
                Spacer(width = 4)
            }
            val textColor by animateColorAsState(
                targetValue = if (isSliderPressed) {
                    Colors.secondary
                } else {
                    Colors.onSurface
                }
            )
            Row {
                Weight()
                Text(
                    text = String.format("%.2f", alpha),
                    style = headlineStyle { small },
                    color = textColor
                )
                Weight()
            }
        }
    }
}

@Preview(
    name = "Light", group = "OverlayAlpha", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun OverlayAlphaSettingsLightPreview() {
    UiTheme.AppTheme {
        var selected by remember { mutableStateOf(.5f) }
        OverlayAlphaSettings(selected) { selected = it }
    }
}

@Composable
@Preview(
    name = "Dark", group = "OverlayAlpha", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun OverlayAlphaSettingsDarkPreview() {
    UiTheme.AppTheme {
        var selected by remember { mutableStateOf(.5f) }
        OverlayAlphaSettings(selected) { selected = it }
    }
}