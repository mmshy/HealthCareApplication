package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetSleepDetails (
    private val repository: StorageServiceImpl
        ) {
    suspend operator fun invoke(sleepId: String): List<SleepDetail>{
        return repository.getSleepDetails(sleepId)
    }
}