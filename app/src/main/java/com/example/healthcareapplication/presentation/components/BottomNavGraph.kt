package com.example.healthcareapplication.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthcareapplication.presentation.components.screens.DashboardScreen
import com.example.healthcareapplication.presentation.components.screens.GoalScreen
import com.example.healthcareapplication.presentation.components.screens.MeScreen
import com.example.healthcareapplication.presentation.components.screens.ReportScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route) {
        composable(route = Screen.Dashboard.route) {
            DashboardScreen()
        }
        composable(route = Screen.Goal.route) {
            GoalScreen()
        }
        composable(route = Screen.Report.route) {
            ReportScreen()
        }
        composable(route = Screen.Me.route) {
            MeScreen()
        }
    }
}