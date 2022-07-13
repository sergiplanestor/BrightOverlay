package com.splanes.commons.ui.component.navhost

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
 * Created on 12/07/2022 at 19:49
 * @author Sergi Planes
 * @since 1.0.0
 */

sealed class NavRedirect : Parcelable {

    @Parcelize
    object OnBack : NavRedirect()

    @Parcelize
    object OnDismiss : NavRedirect()

    @Parcelize
    data class Screen(val route: String) : NavRedirect() {
        companion object
    }
}

fun NavRedirect.Screen.Companion.find(id: String, navGraph: NavGraph) =
    navGraph.all().find { it.id == id }?.route?.let { NavRedirect.Screen(it) }
