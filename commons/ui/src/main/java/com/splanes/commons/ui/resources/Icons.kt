package com.splanes.commons.ui.resources

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

/*
 * Created on 12/07/2022 at 23:17
 * @author Sergi Planes
 * @since 1.0.0
 */
 
inline fun iconRounded(crossinline resolver: Icons.Rounded.() -> ImageVector): ImageVector =
    Icons.Rounded.let(resolver)