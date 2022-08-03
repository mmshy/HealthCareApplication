package com.example.healthcareapplication.domain.usecase

import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.repository.UserRepository
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl

class Authenticate (
    private val repository: UserRepositoryImpl
){
    suspend operator fun invoke(email: String, password: String, onResult: (Throwable?)-> Unit){
        repository.authenticate(email, password, onResult)
    }
}