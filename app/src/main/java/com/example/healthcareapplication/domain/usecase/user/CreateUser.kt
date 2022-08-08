package com.example.healthcareapplication.domain.usecase.user

import android.text.TextUtils
import android.util.Patterns
import com.example.healthcareapplication.domain.model.InvalidUserException
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.repository.UserRepository


class CreateUser(
    private val repository: UserRepository
) {
    @Throws(InvalidUserException::class)
    suspend operator fun invoke(currentUser: User) {
        if(currentUser.email == "")
            throw InvalidUserException("Type your email!")
        else if (!isValidEmail(currentUser.email))
            throw InvalidUserException("Wrong email!")
        else
            repository.authenticate(currentUser.email,currentUser.password){ error ->
                if (error == null) {
                    //TODO: open main screen

                }
                else {
                    //TODO: show error
                }
            }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}
