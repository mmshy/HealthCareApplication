package com.example.healthcareapplication.domain.service

import android.content.ContentValues.TAG
import android.util.Log
import com.example.healthcareapplication.domain.model.Sleep
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class StorageServiceImpl @Inject constructor(
    //
): StorageService {

    private val collection = Firebase.firestore.collection("users")

    override fun addListener() {
        TODO("Not yet implemented")
    }

    override fun removeListener() {
        TODO("Not yet implemented")
    }

    override fun getSleepById(id: String) {
        TODO("Not yet implemented")
    }

    override fun addSleep(sleep: Sleep) {
        try {
            collection.add(sleep)
        } catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
    }

    override suspend fun getSleeps(): List<Sleep> {

        var list = mutableListOf<Sleep>()

        return withContext(Dispatchers.IO) {

            //connect
            try {
                var a = Firebase.firestore
                    .collection("users")
                    .get().await()

//                Log.d("a: ", "${a.documents}")

                if (a != null) {

                    var string = StringBuilder()

                    for (item in a.documents) {
                        val sleep = item.toObject<Sleep>()
                        Log.d("item: ", "$sleep")
                        if (sleep != null) {
                            list.add(sleep)
                        }
//                        Log.d("list...: ", "$list")
                    }
                }
                else {
                    Log.d("get list: ", "empty")
                }

            } catch (e: Exception) {
                Log.d("get list: ", e.message.toString())
            }

            return@withContext list
        }
    }
}