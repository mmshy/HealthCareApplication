package com.example.healthcareapplication.presentation.register

import com.example.healthcareapplication.domain.model.User

sealed class RegisterEvent{
    object CreateUser :RegisterEvent()
}
