package com.example.healthcareapplication.domain.repository

import com.example.healthcareapplication.data.dao.SleepDAO
import com.example.healthcareapplication.domain.model.Sleep
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SleepRepositoryImpl @Inject constructor(
    private val dao: SleepDAO
): SleepRepository {

    override fun getSleeps(): Flow<List<Sleep>>? {
        return dao.getSleeps()
    }

    override suspend fun getSleepById(id: String): Sleep? {
        return dao.getSleepById(id)
    }

    override suspend fun insertSleep(sleep: Sleep) {
        return dao.insertSleep(sleep)
    }

}