package com.example.healthcareapplication.presentation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.healthcareapplication.presentation.components.ForgotPasswordScreen
import com.example.healthcareapplication.presentation.components.LoginScreen
import com.example.healthcareapplication.presentation.components.MainScreen
import com.example.healthcareapplication.presentation.components.RegisterScreen
import com.example.healthcareapplication.presentation.screen.AuthScreens
import com.example.healthcareapplication.presentation.screen.MainScreens

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = AuthScreens.Login.route,
        route = "auth_graph"
    ) {
        composable(route = AuthScreens.Login.route) {
            LoginScreen(
                onRegisterClick = {
                    navController.navigate(AuthScreens.Register.route)
                },
                onSubmitClick = {
                    navController.popBackStack()
                    navController.navigate(route = "home_graph")
                },
                onForgetPasswordClick = {
                    navController.navigate(AuthScreens.ForgotPassword.route)
                }
            )
        }
        composable(route = AuthScreens.Register.route) {
            RegisterScreen(
                onBackToLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AuthScreens.Login.route)
                }
            )
        }
        composable(route = AuthScreens.ForgotPassword.route) {
            ForgotPasswordScreen(
                onSubmitClick = {
                    /*TODO*/
                },
                onBackToLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AuthScreens.Login.route)
                }
            )
        }
    }
}