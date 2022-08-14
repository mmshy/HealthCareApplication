package com.example.healthcareapplication.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.presentation.screens_and_implementtion.screen.MainScreens
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val manState = rememberScaffoldState()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val mainScreens = listOf(
        MainScreens.Dashboard,
        MainScreens.Goal,
        MainScreens.Report,
        MainScreens.Me
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = mainScreens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar() {
            mainScreens.forEach { screen ->
                AddItem(
                    mainScreens = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    mainScreens: MainScreens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        NavigationBarItem(
            label = {
                Text(
                    text = mainScreens.title,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
            },
            icon = {
                Icon(
                    painterResource(id = mainScreens.icon),
                    contentDescription = "Navigation Icon"
                )
            },
            selected = currentDestination?.hierarchy?.any {
                it.route == mainScreens.route
            } == true,
            onClick = {
                navController.navigate(mainScreens.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        )
    }
}