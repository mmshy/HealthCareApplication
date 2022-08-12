package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetSleepById (
    private val repository: StorageServiceImpl
        ) {
    suspend operator fun invoke(id: String): Sleep? {
        return repository.getSleepById(id)
    }
}