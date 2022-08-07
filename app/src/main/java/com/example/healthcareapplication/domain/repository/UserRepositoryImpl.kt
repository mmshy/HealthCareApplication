package com.example.healthcareapplication.domain.repository


import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.model.User
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val dao: UserDAO
) : UserRepository{
    // firebase attributes initialising

    override suspend fun authenticate(email: String, password: String, onResult: (Throwable?)-> Unit) {
        dao.authenticate(email, password, onResult);
    }

    override suspend fun createAccount(newUser: User) {
        dao.createAccount(newUser);
    }

    override suspend fun forgotPassword(email: String) {
        dao.forgotPassword(email);
    }



}

