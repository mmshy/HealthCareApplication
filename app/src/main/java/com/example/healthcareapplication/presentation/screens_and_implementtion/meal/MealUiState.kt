package com.example.healthcareapplication.presentation.screens_and_implementtion.meal

import com.example.healthcareapplication.domain.model.BriefData
import com.example.healthcareapplication.domain.model.Meal

data class MealUiState (
    val greeting: String = "Hi, have a good day!",
    val briefData: List<BriefData> = emptyList(),
    val items: List<Meal> = mutableListOf(),
    val nutritionValue: String = "1",
    val dayTotalCalories: String = "2",
    val numberOfMeals: String = "3",
)
