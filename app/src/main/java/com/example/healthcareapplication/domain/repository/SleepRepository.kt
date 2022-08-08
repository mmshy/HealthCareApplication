package com.example.healthcareapplication.domain.repository

import com.example.healthcareapplication.domain.model.Sleep
import kotlinx.coroutines.flow.Flow

interface SleepRepository {

    fun getSleeps(): Flow<List<Sleep>>?

    suspend fun getSleepById(id: String): Sleep?

    suspend fun insertSleep(sleep: Sleep)
}