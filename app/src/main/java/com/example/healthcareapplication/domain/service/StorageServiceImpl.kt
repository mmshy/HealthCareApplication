package com.example.healthcareapplication.domain.service

import android.util.Log
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.Sleep
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.protobuf.NullValue
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class StorageServiceImpl @Inject constructor(
    //
): StorageService {

    private val db = Firebase.firestore

    override fun addListener() {
        TODO("Not yet implemented")
    }

    override fun removeListener() {
        TODO("Not yet implemented")
    }

    override suspend fun getSleepById(id: String) : Sleep? {
        var value : Sleep? = null
            try{
                value =  db.collection(Constants.KEY_SLEEP_COLLECTION).document(id).get().await().toObject<Sleep>()
            }catch (e: Exception) {
                Log.d(e.toString(), e.toString())
            }
        return value
    }

    override fun addSleep(sleep: Sleep) {
        try {
            db.collection(Constants.KEY_SLEEP_COLLECTION).add(sleep)
        } catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
    }

    override suspend fun getSleeps(): List<Sleep> {

        var list = mutableListOf<Sleep>()

        return withContext(Dispatchers.IO) {

            //connect
            try {
                var querySnapshot = db.collection(Constants.KEY_SLEEP_COLLECTION)
                    .get().await()

//                Log.d("a: ", "${a.documents}")

                if (querySnapshot != null) {

                    var string = StringBuilder()

                    for (item in querySnapshot.documents) {
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

    override fun addMeal(meal: Meal) {
        try{
            db.collection(Constants.KEY_MEAL_COLLECTION).add(meal)
        }catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
    }

    override suspend fun getMealById(id: String): Meal? {
        var value : Meal? = null
        try{
           value =  db.collection(Constants.KEY_MEAL_COLLECTION).document(id).get().await().toObject<Meal>()
        }catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
        return value
    }


    override fun getMeals(): List<Meal> {
        var list : List<Meal> = mutableListOf()

        try {
            for (item in db.collection(Constants.KEY_MEAL_COLLECTION).get().result.documents) {
                val mealItem = item.toObject<Meal>()
                list.plus(mealItem)
            }
        } catch (e: Exception) {

        }

        return list
    }

    //Meal

}