package com.example.healthcareapplication.domain.service

import android.util.Log
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.Sleep
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

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

    override fun getSleepById(id: String) {
        TODO("Not yet implemented")
    }

    //Sleep

    override fun addSleep(sleep: Sleep) {
        try {
            db.collection(Constants.KEY_SLEEP_COLLECTION).add(sleep)
        } catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
    }

    override fun getSleeps(): List<Sleep> {

        var list : List<Sleep> = mutableListOf()

        try {
            for (item in db.document(Constants.KEY_SLEEP_COLLECTION).get().result.documents) {
                val sleep = item.toObject<Sleep>()
                list.plus(sleep)
            }
        } catch (e: Exception) {

        }

        return list
    }

    override fun addMeal(meal: Meal) {
        try{
            db.collection(Constants.KEY_MEAL_COLLECTION).add(meal)
        }catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
    }

    override fun getMealById(id: String) {
        try{
            db.collection(Constants.KEY_MEAL_COLLECTION).document(id).get()
        }catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
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