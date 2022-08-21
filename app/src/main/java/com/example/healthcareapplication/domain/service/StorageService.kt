package com.example.healthcareapplication.domain.service

import com.example.healthcareapplication.domain.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface StorageService {

    fun addListener()
    fun removeListener()

//    Sleep
    suspend fun addSleep(sleep: Sleep)
    suspend fun addSleepDetail(sleepDetail: SleepDetail)
    suspend fun updateSleep(sleepDetail: SleepDetail)
    suspend fun updateSleepDetailState(oldValue: SleepDetail, newValue: SleepDetail)
    suspend fun getSleepById(id: String) : Sleep?
    suspend fun getSleeps(): List<Sleep>
    suspend fun getSleepDetails(sleepId: String): List<SleepDetail>

//    Meal

    suspend fun getMealById(id: String) : Meal?
    fun addMeal(meal: Meal)
    fun getMeals(): List<Meal>

    //MealDetail
    suspend fun getMealDetailById(id: String) : MealDetail?
    fun addMealDetail(sleepDetail: MealDetail)
    suspend fun getMealDetails(): List<MealDetail>

    //WaterDrinking

    suspend fun getWaterDrinkingById(id: String) : WaterDrinking?
    suspend fun addWaterDrinking(waterDrinking: WaterDrinking)
    suspend fun getWaterDrinkings(): List<WaterDrinking>
    suspend fun updateWaterDrinking(waterDrinking: WaterDrinking)
    suspend fun updateWaterDrinkingWithNewDetail(waterDrinkingDetail: WaterDrinkingDetail)

    //WaterDrinkingDetail
    suspend fun getWaterDrinkingDetailById(id: String) : WaterDrinkingDetail?
    suspend fun getWaterDrinkingDetails(id: String): List<WaterDrinkingDetail>
    suspend fun addWaterDrinkingDetail(waterDrinkingDetail: WaterDrinkingDetail)
}