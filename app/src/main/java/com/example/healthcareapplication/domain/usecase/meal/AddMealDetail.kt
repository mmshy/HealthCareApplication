package com.example.healthcareapplication.domain.usecase.meal

import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.MealDetail
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class AddMealDetail (
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(mealDetail: MealDetail){
        repository.addMealDetail(mealDetail)
    }
}