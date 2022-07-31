package com.example.healthcareapplication.domain.usecase


data class UserAccessUseCases(
    val authenticate: Authenticate,
    val createAccount: CreateAccount
)