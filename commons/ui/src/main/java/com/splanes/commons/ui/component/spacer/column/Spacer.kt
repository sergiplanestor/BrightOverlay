package com.splanes.commons.ui.component.spacer.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun ColumnScope.Spacer(height: Int) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun ColumnScope.Weight(factor: Double = 1.0) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(factor.toFloat()))
}

@Composable
fun ColumnScope.Divider(
    modifier: Modifier = Modifier,
    height: Int = 1,
    color: Color = Colors.onSurface,
    alpha: Double = 1.0
) {
    androidx.compose.material.Divider(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .height(height.dp)
            .background(color)
            .alpha(alpha.toFloat()),
        color = color,
        thickness = height.dp
    )
}