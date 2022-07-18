package com.example.healthcareapplication.domain.repository

import com.example.healthcareapplication.domain.model.User
import com.google.firebase.auth.FirebaseAuth

interface UserRepository {
    suspend fun getUser(currentUser: User)

    suspend fun updateUser( newUser: User)
}