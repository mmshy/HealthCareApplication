package com.example.healthcareapplication.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.healthcareapplication.presentation.components.BottomNavGraph
import com.example.healthcareapplication.presentation.components.MainScreen
import com.example.healthcareapplication.presentation.components.MealScreen
import com.example.healthcareapplication.presentation.components.SleepScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "auth_graph",
        route = "root_graph"
    ) {
        authNavGraph(navController = navController)
        composable(route = "home_graph") {
            MainScreen()
        }
    }
}