package com.example.healthcareapplication.domain.usecase.user


data class UserAccessUseCases(
    val authenticate: Authenticate,
    val createAccount: CreateAccount,
    val forgotPassword: ForgotPassword
)