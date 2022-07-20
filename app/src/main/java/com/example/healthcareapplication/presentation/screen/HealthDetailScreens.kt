package com.example.healthcareapplication.presentation.screen

sealed class HealthDetailScreens(
    val route: String
) {
    object Sleep: HealthDetailScreens("sleep")
    object Meal: HealthDetailScreens("meal")
    object Water: HealthDetailScreens("water")
}