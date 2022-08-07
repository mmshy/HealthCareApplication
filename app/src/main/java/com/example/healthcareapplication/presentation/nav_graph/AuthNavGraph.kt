package com.example.healthcareapplication.presentation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.healthcareapplication.common.AUTHENTICATION_GRAPH
import com.example.healthcareapplication.common.HOME_GRAPH
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
        route = AUTHENTICATION_GRAPH
    ) {
        composable(route = AuthScreens.Login.route) {
            LoginScreen(
                onRegisterClick = {
                    navController.navigate(AuthScreens.Register.route)
                },
                onSubmitClick = {
                    navController.popBackStack()
                    navController.navigate(route = HOME_GRAPH)
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
                onSubmitClick = {
                    /*TODO*/
                },
                onBackToLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AuthScreens.Login.route)
                },
                navController = navController
            )
        }
    }
}