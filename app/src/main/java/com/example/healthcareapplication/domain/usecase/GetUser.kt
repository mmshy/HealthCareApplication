package com.example.healthcareapplication.domain.usecase

import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.repository.UserRepository

class GetUser (
    private val repository: UserRepository
){
    suspend operator fun invoke(currentUser: User){
        repository.getUser(currentUser)
    }
}