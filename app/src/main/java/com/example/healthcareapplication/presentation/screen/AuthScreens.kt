package com.example.healthcareapplication.presentation.screen

sealed class AuthScreens (
    val route: String,
) {
    object Login: AuthScreens("login")

    object Register: AuthScreens("register")
}