package com.splanes.brightoverlay.infrastructure.di

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EditNotifications
import androidx.compose.material.icons.rounded.FlipToBack
import com.splanes.overlay.ui.R as ROverlay
import com.splanes.notification.ui.R as RNotification
import com.splanes.commons.ui.component.navhost.NavDestinationInfo
import com.splanes.commons.ui.component.navhost.NavGraph
import com.splanes.commons.ui.resources.iconRounded
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/*
 * Created on 10/07/2022 at 19:16
 * @author Sergi Planes
 * @since 1.0.0
 */

@Module
@InstallIn(SingletonComponent::class)
object NavModule {

    @Provides
    @Named("NotificationsNav")
    fun notificationsNavInfo(): NavDestinationInfo =
        NavDestinationInfo(
            id = "BRIGHT-OVER.NOTIFICATIONS",
            route = "/notifications",
            label = { RNotification.string.notifications },
            icon = iconRounded { EditNotifications }
        )

    @Provides
    @Named("OverlaySettingsNav")
    fun overlayNavInfo(): NavDestinationInfo =
        NavDestinationInfo(
            id = "BRIGHT-OVER.OVERLAY",
            route = "/overlay-settings",
            label = { ROverlay.string.overlay },
            icon = iconRounded { FlipToBack }
        )

    @Provides
    @Singleton
    fun navGraph(
        @Named("NotificationsNav") notifications: NavDestinationInfo,
        @Named("OverlaySettingsNav") overlaySettings: NavDestinationInfo,
    ): NavGraph = NavGraph().apply {
        initial(overlaySettings)
        register(notifications)
    }

}