package com.example.healthcareapplication.domain.usecase.user

import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.repository.UserRepositoryImpl

class CreateAccount (
    private val repository: UserRepositoryImpl
){
    suspend operator fun invoke(currentUser: User){
        repository.createAccount(currentUser)
    }
}
