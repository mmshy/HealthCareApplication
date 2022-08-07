package com.example.healthcareapplication.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.healthcareapplication.common.APPLICATION_GRAPH
import com.example.healthcareapplication.common.AUTHENTICATION_GRAPH
import com.example.healthcareapplication.common.HOME_GRAPH
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
        startDestination = AUTHENTICATION_GRAPH,
        route = APPLICATION_GRAPH
    ) {
        authNavGraph(navController = navController)
        composable(route = HOME_GRAPH) {
            MainScreen()
        }
    }
}