package com.example.healthcareapplication.domain.service

import android.util.Log
import com.example.healthcareapplication.domain.model.Sleep
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    override fun getSleeps(): List<Sleep> {

        var list : List<Sleep> = emptyList()

        try {
            for (item in collection.get().result.documents) {
                val sleep = item.toObject<Sleep>()
                list.plus(sleep)
            }
        } catch (e: Exception) {

        }

        return list
    }
}