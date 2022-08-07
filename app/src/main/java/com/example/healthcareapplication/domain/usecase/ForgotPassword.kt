package com.example.healthcareapplication.domain.usecase

import com.example.healthcareapplication.domain.repository.UserRepositoryImpl


class ForgotPassword (
    private val repository: UserRepositoryImpl
){
    suspend operator fun invoke(email: String){
        repository.forgotPassword(email)
    }
}