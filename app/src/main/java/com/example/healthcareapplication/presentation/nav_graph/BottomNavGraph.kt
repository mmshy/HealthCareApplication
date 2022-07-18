package com.example.healthcareapplication.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthcareapplication.presentation.components.screens.DashboardScreen
import com.example.healthcareapplication.presentation.components.screens.GoalScreen
import com.example.healthcareapplication.presentation.components.screens.MeScreen
import com.example.healthcareapplication.presentation.components.screens.ReportScreen
import com.example.healthcareapplication.presentation.screen.MainScreens

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainScreens.Dashboard.route,
        route = "home_graph"
    ) {
        composable(route = MainScreens.Dashboard.route) {
            DashboardScreen()
        }
        composable(route = MainScreens.Goal.route) {
            navController.popBackStack()
            GoalScreen()
        }
        composable(route = MainScreens.Report.route) {
            navController.popBackStack()
            ReportScreen()
        }
        composable(route = MainScreens.Me.route) {
            navController.popBackStack()
            MeScreen()
        }
    }
}