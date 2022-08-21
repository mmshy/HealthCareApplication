package com.example.healthcareapplication.domain.usecase.waterdrinking

import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class UpdateWaterDrinkingWithNewDetail  (
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(waterDrinkingDetail: WaterDrinkingDetail) {
        return repository.updateWaterDrinkingWithNewDetail(waterDrinkingDetail)
    }
}