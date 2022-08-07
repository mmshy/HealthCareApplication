package com.example.healthcareapplication.presentation.login

sealed class LoginEvent {
    data class EnterName(val name: String): LoginEvent()
    data class EnterPassword(val password: String): LoginEvent()
}