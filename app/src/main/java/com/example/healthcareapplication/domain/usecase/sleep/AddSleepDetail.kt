package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class AddSleepDetail(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(sleepDetail: SleepDetail) {
        return repository.addSleepDetail(sleepDetail)
    }
}