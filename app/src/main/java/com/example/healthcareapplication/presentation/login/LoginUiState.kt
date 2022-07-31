package com.example.healthcareapplication.presentation.login

import com.example.healthcareapplication.domain.model.User

data class LoginUiState (
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
)