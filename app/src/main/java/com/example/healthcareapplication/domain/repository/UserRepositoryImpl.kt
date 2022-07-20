package com.example.healthcareapplication.domain.repository

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.healthcareapplication.domain.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : UserRepository{
    // firebase attributes initialising



    override suspend fun getUser(currrentUser: User) {
        auth.signInWithEmailAndPassword(currrentUser.email, currrentUser.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)

                    //updateUI(null)
                }
            }
    }

    override suspend fun updateUser(newUser: User) {
        auth.createUserWithEmailAndPassword(newUser.email, newUser.password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    //updateUI(null)
                }
            }

    }




}

