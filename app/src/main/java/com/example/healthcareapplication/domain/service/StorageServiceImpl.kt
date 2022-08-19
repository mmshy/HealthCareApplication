package com.example.healthcareapplication.domain.service

import android.util.Log
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.model.*
import com.example.healthcareapplication.presentation.screens_and_implementtion.goal.GoalStatus
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class StorageServiceImpl @Inject constructor(
    //
) : StorageService {

    private val db = Firebase.firestore

    override fun addListener() {
        TODO("Not yet implemented")
    }

    override fun removeListener() {
        TODO("Not yet implemented")
    }

    override suspend fun getSleepById(id: String): Sleep? {
        var value: Sleep? = null
        try {
            value = db.collection(Constants.KEY_SLEEP_COLLECTION).document(id).get().await()
                .toObject<Sleep>()
        } catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
        return value
    }

    override suspend fun addSleep(sleep: Sleep) {
        try {
            db.collection(Constants.KEY_SLEEP_COLLECTION)
                .add(sleep)
                .addOnCompleteListener { value ->
                    sleep.id = value.result.id
                    runBlocking {
                        db.collection(Constants.KEY_SLEEP_COLLECTION)
                            .document(sleep.id)
                            .update("id", sleep.id)
                            .await()

                        db.collection(Constants.KEY_SLEEP_COLLECTION)
                            .document(sleep.id)
                            .collection("sleep_list")
                    }
                    Log.d("add sleep: ", sleep.id)
                }
                .await()
            Log.d("await add sleep: ", "run")
        } catch (e: Exception) {
            Log.d("add sleep: ", e.toString())
        }
    }

    override suspend fun updateSleep(sleepDetail: SleepDetail) {
        try {
            db.collection(Constants.KEY_SLEEP_COLLECTION)
                .document(sleepDetail.sleepId)
                .update("sleepList", FieldValue.arrayUnion(sleepDetail))
                .await()

//            db.collection(Constants.KEY_SLEEP_COLLECTION)
//                .document(sleepDetail.sleepId)
//                .collection("sleep_list")
//                .add(sleepDetail)
//                .addOnCompleteListener { value ->
//                    runBlocking {
//                        db.collection(Constants.KEY_SLEEP_COLLECTION)
//                            .document(sleepDetail.id)
//                            .update("id", sleepDetail.id)
//                            .await()
//                    }
//                }
//                .await()
            Log.d("update sleep: ", "OK")
        } catch (e: Exception) {
            Log.d("update sleep: ", e.toString())
        }
    }

    override suspend fun updateSleepDetailState(oldValue: SleepDetail, newValue: SleepDetail) {
        try {
//            Log.d("old: ", oldValue.finishTime.toDate().toString())
//            Log.d("new: ", newValue.finishTime.toDate().toString())
            db.collection(Constants.KEY_SLEEP_COLLECTION)
                .document(oldValue.sleepId)
                .update("sleepList", FieldValue.arrayRemove(oldValue))
                .addOnCompleteListener {
                    runBlocking {
                        db.collection(Constants.KEY_SLEEP_COLLECTION)
                            .document(oldValue.sleepId)
                            .update("sleepList", FieldValue.arrayUnion(newValue))
                            .await()
                    }
                }
                .await()
            Log.d("update sleep: ", "OK")
        } catch (e: Exception) {
            Log.d("update sleep: ", e.toString())
        }
    }

    override suspend fun addSleepDetail(sleepDetail: SleepDetail) {
        try {

            db.collection(Constants.KEY_SLEEP_DETAIL_COLLECTION)
                .add(sleepDetail)
                .addOnCompleteListener { value ->
//                    sleepDetail.id = value.result.id
//                    Log.d("add sleep detail: ", sleepDetail.id)
                }
                .await()

        } catch (e: Exception) {
            Log.d("add sleep detail: ", e.toString())
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

                    for (item in querySnapshot.documents) {
                        val sleep = item.toObject<Sleep>()
                        Log.d("item: ", "$sleep")
                        if (sleep != null) {
                            list.add(sleep)
                        }
//                        Log.d("list...: ", "$list")
                    }
                } else {
                    Log.d("get list: ", "empty")
                }

            } catch (e: Exception) {
                Log.d("get list: ", e.message.toString())
            }

            return@withContext list
        }
    }

    override suspend fun getSleepDetails(sleepId: String): List<SleepDetail> {

        var list = mutableListOf<SleepDetail>()

        return withContext(Dispatchers.IO) {

            //connect
            try {
                var sleep = db.collection(Constants.KEY_SLEEP_COLLECTION)
                    .document(sleepId)
                    .get().await().toObject<Sleep>()

                var sleepList = sleep?.sleepList

                if (sleepList != null) {
                    for (item in sleepList) {
                        list.add(item)
                    }
                }

                Log.d("hihi:", sleep?.sleepList?.get(0)?.startTime.toString())

                Log.d("get list:", "running...")

            } catch (e: Exception) {
                Log.d("get list: ", e.message.toString())
            }

            return@withContext list
        }
    }

    //Meal

    override fun addMeal(meal: Meal) {
        try {
            db.collection(Constants.KEY_MEAL_COLLECTION).add(meal)
        } catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
    }

    override suspend fun getMealById(id: String): Meal? {
        var value: Meal? = null
        try {
            value = db.collection(Constants.KEY_MEAL_COLLECTION).document(id).get().await()
                .toObject<Meal>()
        } catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
        return value
    }

    override fun getMeals(): List<Meal> {
        var list: List<Meal> = mutableListOf()

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
    // Meal Detail

    override fun addMealDetail(sleepDetail: MealDetail) {
        TODO("Not yet implemented")
    }

    override suspend fun getMealDetails(): List<MealDetail> {
        TODO("Not yet implemented")
    }

    override suspend fun getWaterDrinkingById(id: String): WaterDrinking? {
        var value : WaterDrinking? = null
        try{
            value =  db.collection(Constants.KEY_WATERDRINKING_COLLECTION).document(id).get().await().toObject<WaterDrinking>()
        }catch (e: Exception) {
            Log.d(e.toString(), e.toString())
        }
        return value
    }

    //WaterDrinking
    override suspend fun addWaterDrinking(waterDrinking: WaterDrinking) {
        try {
            db.collection(Constants.KEY_WATERDRINKING_COLLECTION)
                .add(waterDrinking)
                .addOnCompleteListener { value ->
                    waterDrinking.id = value.result.id
                    runBlocking {
                        db.collection(Constants.KEY_SLEEP_COLLECTION)
                            .document(waterDrinking.id)
                            .update("id", waterDrinking.id)
                            .await()
                    }
                    Log.d("add water drinking: ", waterDrinking.id)
                }
                .await()
            Log.d("await water drinking: ", "run")
        } catch (e: Exception) {
            Log.d("add water drinking: ", e.toString())
        }    }

    override suspend fun getWaterDrinkings(): MutableList<WaterDrinking> {
        var list = mutableListOf<WaterDrinking>()

        return withContext(Dispatchers.IO) {

            //connect
            try {
                var querySnapshot = db.collection(Constants.KEY_WATERDRINKING_COLLECTION)
                    .get().await()

//                Log.d("a: ", "${a.documents}")

                if (querySnapshot != null) {

                    var string = StringBuilder()

                    for (item in querySnapshot.documents) {
                        val water = item.toObject<WaterDrinking>()
                        Log.d("item: ", "$water")
                        if (water != null) {
                            list.add(water)
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

    override suspend fun updateWaterDrinking(waterDrinking: WaterDrinking) {
        try {
            db.collection(Constants.KEY_WATERDRINKING_COLLECTION)
                .document(waterDrinking.id)
                .update("waterDrinkingList", waterDrinking.waterDrinkingList)
                .await()
            Log.d("update water drinking: ", "OK")
        } catch (e: Exception) {
            Log.d("update water drinking: ", e.toString())
        }
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

    // Goal

    override suspend fun getGoals(goalStatus: GoalStatus): List<Goal> {

        var list = mutableListOf<Goal>()

        db.collection(Constants.KEY_GOAL_COLLECTION)
            .whereEqualTo("status", goalStatus)
            .get()
            .addOnCompleteListener {
                for (item in it.result.documents) {
//                    Log.d("get goals: ", item.id)
                    val goal = item.toObject<Goal>()
                    if (goal != null) {
                        list.add(goal)
                    }
                }
            }
            .await()

        return list
    }

    override suspend fun addGoal(goal: Goal) {
        db.collection(Constants.KEY_GOAL_COLLECTION)
            .add(goal)
            .addOnCompleteListener {
                goal.goalId = it.result.id
                runBlocking {
                    db.collection(Constants.KEY_GOAL_COLLECTION)
                        .document(goal.goalId)
                        .update("goalId", goal.goalId)
                        .await()
                }
            }
            .await()
        Log.d("add goal:", "OK")
    }


}