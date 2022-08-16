package com.example.healthcareapplication.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthcareapplication.common.HOME_GRAPH
import com.example.healthcareapplication.common.MEAL_NAVIGATION
import com.example.healthcareapplication.common.SLEEP_NAVIGATION
import com.example.healthcareapplication.presentation.components.screens.DashboardScreen
import com.example.healthcareapplication.presentation.components.screens.GoalScreen
import com.example.healthcareapplication.presentation.components.screens.MeScreen
import com.example.healthcareapplication.presentation.components.screens.ReportScreen
import com.example.healthcareapplication.presentation.screens_and_implementtion.screen.MainScreens

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainScreens.Dashboard.route,
        route = HOME_GRAPH
    ) {
        composable(route = MainScreens.Dashboard.route) {
            DashboardScreen(
                navController = navController
            )
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
        composable(route = SLEEP_NAVIGATION) {
            SleepScreen()
        }
        composable(route = MEAL_NAVIGATION) {
            MealScreen()
        }
    }
}