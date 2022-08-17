package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class AddSleep(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(sleep: Sleep){
        repository.addSleep(sleep)
    }
}