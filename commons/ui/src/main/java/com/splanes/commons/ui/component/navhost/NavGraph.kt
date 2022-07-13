package com.splanes.commons.ui.component.navhost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.splanes.commons.tools.utils.scope.orThrow
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.navGraphTransitionMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
 * Created on 12/07/2022 at 18:43
 * @author Sergi Planes
 * @since 1.0.0
 */

class NavGraph {

    private var initial: String? = null
    private val navMap: MutableMap<String, NavDestinationInfo> = mutableMapOf()
    private var navHostController: NavHostController? = null
    private val destinationFlow: Flow<NavDestination> get() =
        controller().currentBackStackEntryFlow.map { it.destination }

    fun controller(): NavHostController = navHostController ?: throw NotImplementedError()

    fun bindController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }

    fun initDestinationId() = controller().graph.findStartDestination().id

    @Composable
    fun current() = destinationFlow.collectAsState(initial = null)

    fun redirect(navRedirect: NavRedirect) {
        when (navRedirect) {
            NavRedirect.OnBack -> back()
            NavRedirect.OnDismiss -> back()
            is NavRedirect.Screen -> redirect(navRedirect.route)
        }
    }

    fun back() = controller().popBackStack()

    fun redirect(route: String, builder: NavOptionsBuilder.() -> Unit = {}) =
        controller().navigate(route, builder)

    fun initial(destination: NavDestinationInfo) {
        initial = destination.id
        register(destination)
    }

    fun register(destination: NavDestinationInfo) {
        navMap[destination.id] = destination
    }

    fun all(): List<NavDestinationInfo> = navMap.values.toList()

    fun initial(): NavDestinationInfo = navMap[initial].orThrow("Initial navigation destination not set.")

}

fun NavGraph.info(destination: NavDestination) =
    all().first { it.route == destination.route }

inline fun NavGraph.forEach(consumer: NavDestinationInfo.() -> Unit) {
    all().forEach(consumer)
}