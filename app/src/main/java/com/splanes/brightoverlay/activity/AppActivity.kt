package com.splanes.brightoverlay.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.splanes.commons.ui.component.navhost.NavGraph
import com.splanes.toolkit.compose.ui.theme.UiTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
 * Created on 10/07/2022 at 17:54
 * @author Sergi Planes
 * @since 1.0.0
 */

@AndroidEntryPoint
class AppActivity : ComponentActivity() {

    @Inject
    lateinit var navGraph: NavGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UiTheme.AppTheme {
                navGraph.bindController(rememberNavController())
                AppComponent(navGraph)
            }
        }
    }
}

