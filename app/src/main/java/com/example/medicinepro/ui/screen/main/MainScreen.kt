@file:Suppress("DEPRECATION")

package com.example.medicinepro.ui.screen.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.medicinepro.ui.screen.navigation.Routes
import com.example.medicinepro.ui.screen.navigation.mainNavGraph
import com.example.medicinepro.ui.theme.MedicineProTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost

@Preview
@Composable
private fun MainScreenPreview() {
    MedicineProTheme {
        MainScreen()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()

    Scaffold(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surface),
        bottomBar = { ExBottomBar(navHostController = navHostController) }) { paddingValues ->
        AnimatedNavHost(
            navController = navHostController,
            startDestination = Routes.MAIN.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            mainNavGraph()
        }
    }
}

@Composable
fun ExBottomBar(modifier: Modifier = Modifier, navHostController: NavHostController) {


    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    var currentRoute by remember { mutableStateOf(Routes.HOME.name) }

    val newRoute = when (navBackStackEntry?.destination?.route) {
        Routes.HOME.name -> Routes.HOME.name
        Routes.LOCATION.name -> Routes.LOCATION.name
        Routes.DATE.name -> Routes.DATE.name
        Routes.USER.name -> Routes.USER.name
        else -> currentRoute
    }

    LaunchedEffect(newRoute) {
        if (newRoute != currentRoute) {
            currentRoute = newRoute
        }
    }


    val items = listOf(Routes.HOME, Routes.LOCATION, Routes.DATE, Routes.USER)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiary)
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            items.forEachIndexed { _, route ->
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            if (currentRoute == route.name)
                                return@clickable
                            when (route) {
                                Routes.HOME -> {
                                    navHostController.navigate(route.name) {
                                        popUpTo(Routes.HOME.name) { inclusive = true }
                                        launchSingleTop = true
                                    }
                                }

                                else -> {
                                    navHostController.navigate(route.name) {
                                        popUpTo(Routes.HOME.name) { inclusive = false }
                                        launchSingleTop = true
                                    }
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(if (currentRoute == route.name) route.selectedIcon!! else route.icon!!),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                            .padding(12.dp)
                            .background(
                                if (currentRoute == route.name) Color(0xFFf3f4f6) else Color.Transparent,
                                CircleShape
                            )
                            .padding(12.dp),
                        tint = if (currentRoute == route.name) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        }
    }
}