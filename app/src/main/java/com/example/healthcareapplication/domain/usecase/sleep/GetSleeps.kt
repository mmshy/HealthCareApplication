package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetSleeps(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(): List<Sleep>{
        return repository.getSleeps()
    }
}