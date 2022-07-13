package com.splanes.commons.ui.component.spacer.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors

/*
 * Created on 10/07/2022 at 9:42
 * @author Sergi Planes
 * @since 1.0.0
 */


@Composable
fun RowScope.Spacer(width: Int) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(width.dp))
}

@Composable
fun RowScope.Weight(factor: Double = 1.0) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(factor.toFloat()))
}

@Composable
fun RowScope.Divider(
    modifier: Modifier = Modifier,
    width: Int = 1,
    color: Color = Colors.onSurface,
    alpha: Double = 1.0
) {
    androidx.compose.material.Divider(
        modifier = Modifier
            .fillMaxHeight()
            .then(modifier)
            .width(width.dp)
            .background(color)
            .alpha(alpha.toFloat()),
        color = color,
        thickness = width.dp
    )
}