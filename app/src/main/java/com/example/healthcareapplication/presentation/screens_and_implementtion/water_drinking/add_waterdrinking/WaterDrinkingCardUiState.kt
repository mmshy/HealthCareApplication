package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.add_waterdrinking

import com.example.healthcareapplication.domain.model.MealType
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.domain.model.WaterType
import com.google.firebase.Timestamp

data class WaterDrinkingCardUiState (
    val stateVisible: Boolean = false,
    var amount: Int = 0,

)
