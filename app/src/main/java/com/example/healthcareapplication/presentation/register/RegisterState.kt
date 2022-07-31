package com.example.healthcareapplication.presentation.register

data class RegisterState(
    val isLoading: Boolean = false,
    val correctEmailFormat : Boolean = false,
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: String = ""
)
