package com.example.healthcareapplication.presentation.register

import com.example.healthcareapplication.domain.model.User

sealed class RegisterEvent{
    data class CreateUser(val newUser: User) :RegisterEvent()
    data class EnterEmail(val newEmail: String) : RegisterEvent()
    data class EnterName(val newName: String) : RegisterEvent()
    data class EnterPassword(val newPassword: String) : RegisterEvent()
    data class EnterConfirmPassword(val newConfirmPassword: String) : RegisterEvent()
    object user : RegisterEvent()
}
