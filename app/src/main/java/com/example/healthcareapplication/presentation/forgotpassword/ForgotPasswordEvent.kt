package com.example.healthcareapplication.presentation.forgotpassword

import com.example.healthcareapplication.domain.model.User

sealed class ForgotPasswordEvent{
    object ResendPassword :ForgotPasswordEvent()
    data class EnterEmail(val newEmail: String) : ForgotPasswordEvent()
}
