package com.example.healthcareapplication.domain.usecase.waterdrinking

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.WaterDrinking
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class AddWaterDrinking (
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(water: WaterDrinking){
        repository.addWaterDrinking(water)
    }
}