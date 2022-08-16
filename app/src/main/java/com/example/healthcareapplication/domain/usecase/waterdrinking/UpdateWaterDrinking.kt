package com.example.healthcareapplication.domain.usecase.waterdrinking

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.WaterDrinking
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class UpdateWaterDrinking (
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(waterDrinking: WaterDrinking) {
        return repository.updateWaterDrinking(waterDrinking)
    }
}