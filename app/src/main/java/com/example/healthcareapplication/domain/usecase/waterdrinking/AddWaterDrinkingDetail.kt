package com.example.healthcareapplication.domain.usecase.waterdrinking

import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class AddWaterDrinkingDetail (
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(waterDrinkingDetail: WaterDrinkingDetail) {
        return repository.addWaterDrinkingDetail(waterDrinkingDetail)
    }
}