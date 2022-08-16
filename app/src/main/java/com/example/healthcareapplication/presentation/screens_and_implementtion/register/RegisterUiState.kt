package com.example.healthcareapplication.presentation.screens_and_implementtion.register

data class RegisterUiState(
    val isLoading: Boolean = false,
    val correctEmailFormat : Boolean = false,
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: String = ""
)
