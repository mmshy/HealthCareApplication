package com.example.healthcareapplication.domain.usecase.meal

import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.MealDetail
import com.example.healthcareapplication.domain.model.MealType
import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetMealDetails(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(meal: Meal, type: MealType?): List<MealDetail> {
        return repository.getMealDetails(meal, type)
    }
}