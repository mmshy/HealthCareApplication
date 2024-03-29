package com.example.healthcareapplication.domain.usecase.meal

import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetMeal(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(id: String){
        repository.getMealById(id)
    }
}