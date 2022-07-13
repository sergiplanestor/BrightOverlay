package com.splanes.overlay.ui.screen.subcomponents

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.FilterChip
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.splanes.commons.ui.component.spacer.column.Spacer
import com.splanes.commons.ui.component.spacer.row.Spacer
import com.splanes.commons.ui.component.spacer.row.Weight
import com.splanes.commons.ui.resources.minus
import com.splanes.commons.ui.resources.plus
import com.splanes.commons.ui.resources.stringOf
import com.splanes.commons.ui.theme.bodyStyle
import com.splanes.commons.ui.theme.titleStyle
import com.splanes.overlay.ui.R
import com.splanes.overlay.ui.utils.OverlayColors
import com.splanes.overlay.ui.utils.items
import com.splanes.overlay.ui.utils.toColor
import com.splanes.toolkit.compose.ui.components.common.utils.color.alpha
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors

/*
 * Created on 13/07/2022 at 0:37
 * @author Sergi Planes
 * @since 1.0.0
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OverlayColorSettings(color: Color, onChange: (Color) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(size = 12.dp),
        border = BorderStroke(width = 1.3.dp, color = Color.Transparent),
        elevation = 4.dp,
        color = Colors.tertiary.alpha(.3).compositeOver(Colors.background)
    ) {
        val colors = OverlayColors.items()
        var selected by remember {
            mutableStateOf(colors.find { it.value == color.value.toLong() } ?: colors.first())
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = stringOf { R.string.overlay_settings_layer_color },
                style = titleStyle { large }.run { copy(fontSize = fontSize + 6.sp) },
                fontWeight = FontWeight.Medium
            )
            Spacer(height = 8)
            Row {
                LazyVerticalGrid(
                    modifier = Modifier.weight(1f),
                    columns = GridCells.Fixed(2)
                ) {
                    itemsIndexed(colors) { index, color ->
                        FilterChip(
                            modifier = Modifier.padding(
                                start = if (index % 2 != 0) 8.dp else 0.dp,
                                end = if (index % 2 == 0) 8.dp else 0.dp
                            ),
                            selected = color == selected,
                            onClick = {
                                selected = color
                                onChange(color.toColor())
                            },
                            colors = ChipDefaults.filterChipColors(
                                backgroundColor = Colors.surface,
                                contentColor = Colors.onSurface,
                                selectedBackgroundColor = Colors.primaryContainer.alpha(.4),
                                selectedContentColor = Colors.onPrimary
                            )
                        ) {
                            Text(
                                text = color.colorName,
                                style = bodyStyle { large },
                                color = if (color == selected) Colors.primary else Colors.onSurface,
                                fontWeight = FontWeight.Bold.takeIf { color == selected }
                            )
                        }
                    }
                }
                Weight(.1)
                Box(
                    modifier = Modifier
                        .weight(.65f)
                        .align(Alignment.CenterVertically),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(75.dp)
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.img_andy),
                        contentDescription = null
                    )
                    Surface(
                        modifier = Modifier.size(100.dp),
                        color = selected.toColor().alpha(.6),
                        shape = CircleShape,
                        content = {}
                    )
                }
            }
            Spacer(height = 12)
        }
    }
}

@Composable
@Preview(
    name = "Light", group = "OverlayColor", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
private fun OverlayColorSettingsLightPreview() {
    UiTheme.AppTheme {
        var selected by remember { mutableStateOf(OverlayColors.Black.toColor()) }
        OverlayColorSettings(selected) { selected = it }
    }
}

@Composable
@Preview(
    name = "Dark", group = "OverlayColor", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun OverlayColorSettingsDarkPreview() {
    UiTheme.AppTheme {
        var selected by remember { mutableStateOf(OverlayColors.Black.toColor()) }
        OverlayColorSettings(selected) { selected = it }
    }
}