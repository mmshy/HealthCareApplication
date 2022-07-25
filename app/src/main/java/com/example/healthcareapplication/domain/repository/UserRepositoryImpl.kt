package com.example.healthcareapplication.domain.repository


import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.data.dao.UserDao1
import com.example.healthcareapplication.domain.model.User
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val dao: UserDAO
) : UserRepository{
    // firebase attributes initialising

    override suspend fun getUser(currrentUser: User) {
       return dao.getUser(currrentUser);
    }

    override suspend fun updateUser(newUser: User) {
        dao.updateUser(newUser);
    }

}

