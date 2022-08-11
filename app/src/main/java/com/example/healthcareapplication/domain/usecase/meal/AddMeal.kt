package com.example.healthcareapplication.domain.usecase.meal

import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class AddMeal(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(meal: Meal){
        repository.addMeal(meal)
    }
}