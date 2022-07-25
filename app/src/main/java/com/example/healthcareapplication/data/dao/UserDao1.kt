package com.example.healthcareapplication.data.dao

import android.content.ContentValues
import android.util.Log
import androidx.room.Dao
import com.example.healthcareapplication.domain.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Dao
interface UserDao1 {
    suspend fun getUser(currentUser: User) {
        Firebase.auth.signInWithEmailAndPassword(currentUser.email, currentUser.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    val user = Firebase.auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)

                    //updateUI(null)
                }
            }
    }

    suspend fun updateUser(newUser: User) {
        Firebase.auth.createUserWithEmailAndPassword(newUser.email, newUser.password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                    val user = Firebase.auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    //updateUI(null)
                }
            }
    }
}