package com.example.healthcareapplication.domain.repository

import com.example.healthcareapplication.domain.model.User
import com.google.firebase.auth.FirebaseAuth

interface UserRepository {

    suspend fun authenticate(email: String, password: String, onResult: (Throwable?)-> Unit)

    suspend fun createAccount(newUser: User)
}