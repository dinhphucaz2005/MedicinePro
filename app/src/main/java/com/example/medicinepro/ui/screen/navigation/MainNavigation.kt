package com.example.medicinepro.ui.screen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.medicinepro.ui.screen.main.date.DateScreen
import com.example.medicinepro.ui.screen.main.home.HomeScreen
import com.example.medicinepro.ui.screen.main.location.LocationScreen
import com.example.medicinepro.ui.screen.main.user.UserScreen

fun NavGraphBuilder.mainNavGraph() {
    navigation(startDestination = Routes.HOME.name, route = Routes.MAIN.name) {
        composable(route = Routes.HOME.name) { HomeScreen() }
        composable(route = Routes.LOCATION.name) { LocationScreen() }
        composable(route = Routes.DATE.name) { DateScreen() }
        composable(route = Routes.USER.name) { UserScreen() }
    }
}