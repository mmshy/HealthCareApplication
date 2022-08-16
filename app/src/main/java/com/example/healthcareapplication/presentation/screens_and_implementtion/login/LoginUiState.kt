package com.example.healthcareapplication.presentation.screens_and_implementtion.login

data class LoginUiState (
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
)