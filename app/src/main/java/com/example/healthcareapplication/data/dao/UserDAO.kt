package com.example.healthcareapplication.data.dao

import android.content.ContentValues.TAG
import android.util.Log
import com.example.healthcareapplication.di.AppModule
import com.example.healthcareapplication.domain.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class UserDAO (

) {
    // firebase attributes initialising

    suspend fun authenticate(email: String, password: String, onResult: (Throwable?)-> Unit) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                onResult(it.exception)
            }

    }

    suspend fun createAccount(newUser: User) {
        Firebase.auth.createUserWithEmailAndPassword(newUser.email, newUser.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = Firebase.auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    //updateUI(null)
                }
            }
    }

    suspend fun forgotPassword(email: String) {
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if(task.isSuccessful){
                // make some toast
            }
            else{
                // same
            }
        }
    }

    suspend fun getUser(currentUser: User) {
        Firebase.auth.signInWithEmailAndPassword(currentUser.email, currentUser.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = Firebase.auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    //updateUI(null)
                }
            }
    }
}

