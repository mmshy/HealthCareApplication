package com.example.healthcareapplication.domain.service

import android.util.Log
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.*
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

    override suspend fun getSleepDetailById(id: String): SleepDetail? {
        TODO("Not yet implemented")
    }

    override fun addSleepDetail(sleepDetail: SleepDetail) {
        TODO("Not yet implemented")
    }

    override suspend fun getSleepDetails(): List<SleepDetail> {
        TODO("Not yet implemented")
    }

    //Meal
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

    override suspend fun getMealDetailById(id: String): MealDetail? {
        TODO("Not yet implemented")
    }

    override fun addMealDetail(sleepDetail: MealDetail) {
        TODO("Not yet implemented")
    }

    override suspend fun getMealDetails(): List<MealDetail> {
        TODO("Not yet implemented")
    }

    override suspend fun GetWaterDrinkingById(id: String): WaterDrinking? {
        TODO("Not yet implemented")
    }

    override fun addWaterDrinking(waterDrinking: WaterDrinking) {
        TODO("Not yet implemented")
    }

    override fun getWaterDrinkings(): List<WaterDrinking> {
        TODO("Not yet implemented")
    }

    override suspend fun getWaterDrinkingDetailById(id: String): WaterDrinking? {
        TODO("Not yet implemented")
    }

    override fun addWaterDrinkingDetail(sleepDetail: WaterDrinking) {
        TODO("Not yet implemented")
    }

    override suspend fun getWaterDrinkingDetails(): List<WaterDrinking> {
        TODO("Not yet implemented")
    }

    // Meal Detail





}