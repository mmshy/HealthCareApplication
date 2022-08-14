package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class UpdateSleep(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(sleepId: String, sleepDetail: SleepDetail) {
        return repository.updateSleep(sleepId, sleepDetail)
    }
}