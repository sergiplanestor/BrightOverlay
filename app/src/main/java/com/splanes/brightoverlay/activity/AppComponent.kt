package com.splanes.brightoverlay.activity

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.splanes.brightoverlay.app.Notifications
import com.splanes.brightoverlay.app.Overlay
import com.splanes.commons.ui.component.navhost.NavGraph
import com.splanes.commons.ui.component.navhost.forEach
import com.splanes.commons.ui.component.navhost.info
import com.splanes.commons.ui.resources.minus
import com.splanes.commons.ui.resources.stringOf
import com.splanes.commons.ui.theme.displayStyle
import com.splanes.commons.ui.theme.headlineStyle
import com.splanes.commons.ui.theme.titleStyle
import com.splanes.overlay.ui.screen.OverlaySettings
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors
import com.splanes.brightoverlay.R.string as Strings

/*
 * Created on 12/07/2022 at 18:18
 * @author Sergi Planes
 * @since 1.0.0
 */


@Composable
internal fun AppComponent(navGraph: NavGraph) {
    Scaffold(
        topBar = { AppTopBar(navGraph) },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Colors.tertiaryContainer,
                contentColor = Colors.onTertiaryContainer,
                elevation = 12.dp,
                content = { BottomNavigationItems(navGraph) }
            )
        },
        backgroundColor = Colors.background,
        contentColor = Colors.onBackground
    ) { paddings ->
        NavHost(
            modifier = Modifier.padding(paddings),
            navController = navGraph.controller(),
            startDestination = navGraph.initial().route
        ) {
            navGraph.forEach {
                composable(route) {
                    when (id) {
                        Notifications -> {
                            NotificationsScreen()
                        }
                        Overlay -> {
                            OverlaySettingsScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AppTopBar(navGraph: NavGraph) {
    Crossfade(navGraph.current().value) { nav ->
        val label = nav?.let { navGraph.info(it).label() } ?: Strings.app_name
        TopAppBar(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 12.dp),
            title = {
                Text(
                    text = stringOf { label },
                    style = headlineStyle().run { copy(fontSize = displayStyle().fontSize) },
                    fontWeight = FontWeight.Light,
                    color = Colors.onBackground
                )
            },
            backgroundColor = Color.Transparent,
            contentColor = Colors.onBackground,
            elevation = 0.dp
        )
    }
}

@Composable
private fun RowScope.BottomNavigationItems(navGraph: NavGraph) {
    navGraph.forEach {
        BottomNavigationItem(
            icon = { icon?.let { ic -> Icon(ic, contentDescription = null) } },
            label = { Text(text = stringOf(label)) },
            selected = navGraph.current().value?.route == route,
            onClick = {
                navGraph.redirect(route) {
                    popUpTo(navGraph.initDestinationId()) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}

@Composable
private fun NotificationsScreen() {

}

@Composable
private fun OverlaySettingsScreen() {
    OverlaySettings()
}
