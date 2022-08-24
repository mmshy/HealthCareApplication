package com.example.healthcareapplication.presentation.screens_and_implementtion.meal.add_meal

import com.example.healthcareapplication.domain.model.FoodCategory
import com.example.healthcareapplication.domain.model.MealType

data class MealCardUiState(
    val mealType: MealType = MealType.BREAKFAST,
    val foodCategory: FoodCategory? = null,
    val mealTypeList: List<MealType> = emptyList(),
    val amount: Int = 0,
    val calories: Int = 0
)