package com.example.healthcareapplication.domain.usecase

import com.example.healthcareapplication.domain.repository.UserRepository


data class UserAcessUseCases(
    val getUser: GetUser,
    val updateUser: UpdateUser
)