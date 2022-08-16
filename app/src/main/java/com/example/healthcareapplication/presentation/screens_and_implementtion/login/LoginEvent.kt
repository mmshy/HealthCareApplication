package com.example.healthcareapplication.presentation.screens_and_implementtion.login

sealed class LoginEvent {
    data class EnterName(val name: String): LoginEvent()
    data class EnterPassword(val password: String): LoginEvent()
}