package com.example.healthcareapplication.presentation.screen

sealed class AuthScreens (
    val route: String,
) {
    object Login: AuthScreens("login")
    object Register: AuthScreens("register")
    object ForgotPassword: AuthScreens("forgot_password")
}