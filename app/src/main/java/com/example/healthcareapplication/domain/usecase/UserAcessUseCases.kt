package com.example.healthcareapplication.domain.usecase

import com.example.healthcareapplication.domain.repository.UserRepository


data class UserAcessUseCases(
    val createUser: CreateUser,
    val getUser: GetUser,
    val updateUser: UpdateUser
)