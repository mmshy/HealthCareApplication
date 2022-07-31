package com.example.healthcareapplication.presentation.register

import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.UpdateUser

sealed class RegisterEvent{
    data class CreateUser(val newUser: User) :RegisterEvent()
    object user : RegisterEvent()
}
