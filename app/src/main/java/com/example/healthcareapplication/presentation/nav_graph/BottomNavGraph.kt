package com.example.healthcareapplication.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthcareapplication.common.*
import com.example.healthcareapplication.presentation.components.screens.DashboardScreen
import com.example.healthcareapplication.presentation.components.screens.GoalScreen
import com.example.healthcareapplication.presentation.screens_and_implementtion.MeScreen
import com.example.healthcareapplication.presentation.components.screens.ReportScreen
import com.example.healthcareapplication.presentation.profile.ProfileScreen
import com.example.healthcareapplication.presentation.profile.healthdata.HealthDataScreen
import com.example.healthcareapplication.presentation.screens_and_implementtion.profile.setting.SettingScreen
import com.example.healthcareapplication.presentation.screens_and_implementtion.screen.MainScreens
import com.example.healthcareapplication.presentation.screens_and_implementtion.sleep.SleepScreen

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
//            navController.popBackStack()
            GoalScreen()
        }
        composable(route = MainScreens.Report.route) {
//            navController.popBackStack()
            ReportScreen()
        }
        composable(route = MainScreens.Me.route) {
//            navController.popBackStack()
            MeScreen(
                navController = navController
            )
        }
        composable(route = SLEEP_NAVIGATION) {
            SleepScreen()
        }
        composable(route = MEAL_NAVIGATION) {
            MealScreen()
        }

        composable(route = ME_PERSONAL_NAVIGATION) {
            ProfileScreen()
        }
        composable(route = ME_HEALTH_DATA_NAVIGATION) {
            HealthDataScreen()
        }
        composable(route = ME_SETTING_NAVIGATION) {
            SettingScreen()
        }
    }
}