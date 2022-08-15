package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class UpdateSleepDetail(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(oldValue: SleepDetail, newValue: SleepDetail) {
        return repository.updateSleepDetailState(oldValue, newValue)
    }
}