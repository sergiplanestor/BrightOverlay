package com.splanes.commons.ui.component.navhost

import android.os.Parcelable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/*
 * Created on 12/07/2022 at 18:29
 * @author Sergi Planes
 * @since 1.0.0
 */

@Parcelize
data class NavDestinationInfo(
    val id: String,
    val route: String,
    val label: () -> Int = { throw NotImplementedError() },
    val icon: @RawValue ImageVector? = null,
    val args: @RawValue List<NamedNavArgument> = emptyList(),
    val deepLinks: @RawValue List<NavDeepLink> = emptyList()
) : Parcelable