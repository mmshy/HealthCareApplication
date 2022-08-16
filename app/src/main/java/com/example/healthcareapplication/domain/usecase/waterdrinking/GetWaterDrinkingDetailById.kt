package com.example.healthcareapplication.domain.usecase.waterdrinking

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.WaterDrinking
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetWaterDrinkingDetailById (
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(id: String): WaterDrinking?{
        return repository.getWaterDrinkingById(id)
    }
}