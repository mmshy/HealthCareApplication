package com.example.healthcareapplication.domain.usecase.waterdrinking

import com.example.healthcareapplication.domain.model.WaterDrinking
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetWaterDrinkingDetails(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(id: String): List<WaterDrinkingDetail>{
        return repository.getWaterDrinkingDetails(id)
    }
}