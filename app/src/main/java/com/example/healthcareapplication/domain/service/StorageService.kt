package com.example.healthcareapplication.domain.service

import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.Sleep
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface StorageService {

    fun addListener()
    fun removeListener()

//    Sleep
suspend fun getSleepById(id: String) : Sleep?
    fun addSleep(sleep: Sleep)
    suspend fun getSleeps(): List<Sleep>

//    Meal

    suspend fun getMealById(id: String) : Meal?
    fun addMeal(meal: Meal)
    fun getMeals(): List<Meal>

}