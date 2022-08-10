package com.example.healthcareapplication.domain.service

import com.example.healthcareapplication.domain.model.Sleep
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface StorageService {

    fun addListener()
    fun removeListener()

//    Sleep
    fun getSleepById(id: String)
    fun addSleep(sleep: Sleep)
    fun getSleeps(): List<Sleep>

//    Meal

}