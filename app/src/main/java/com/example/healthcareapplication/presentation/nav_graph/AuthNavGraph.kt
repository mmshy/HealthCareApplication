package com.example.healthcareapplication.presentation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.healthcareapplication.common.AUTHENTICATION_GRAPH
import com.example.healthcareapplication.presentation.components.ForgotPasswordScreen
import com.example.healthcareapplication.presentation.components.LoginScreen
import com.example.healthcareapplication.presentation.components.RegisterScreen
import com.example.healthcareapplication.presentation.screens_and_implementtion.screen.AuthScreens

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = AuthScreens.Login.route,
        route = AUTHENTICATION_GRAPH
    ) {
        composable(route = AuthScreens.Login.route) {
            LoginScreen(
                onRegisterClick = {
                    navController.navigate(AuthScreens.Register.route)
                },
                onForgetPasswordClick = {
                    navController.navigate(AuthScreens.ForgotPassword.route)
                },
                navController = navController
            )
        }
        composable(route = AuthScreens.Register.route) {
            RegisterScreen(
                onBackToLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AuthScreens.Login.route)
                },
                navController = navController
            )
        }
        composable(route = AuthScreens.ForgotPassword.route) {
            ForgotPasswordScreen(
                onBackToLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AuthScreens.Login.route)
                },
                navController = navController
            )
        }
    }
}