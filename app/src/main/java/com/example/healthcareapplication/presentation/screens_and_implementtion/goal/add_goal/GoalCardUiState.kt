package com.example.healthcareapplication.presentation.screens_and_implementtion.goal.add_goal

import com.google.firebase.Timestamp

data class GoalCardUiState(
    val startDate: Timestamp = Timestamp.now(),
    val endDate: Timestamp = Timestamp.now(),
    val goalType: GoalType = GoalType.LOSE_WEIGHT,
    val goalTypeList: List<GoalType> = emptyList(),
    val name: String = ""
)

enum class GoalType(val analyticsName: String) {
    LOSE_WEIGHT("Lose Weight"),
    GAIN_WEIGHT("Gain Weight"),
    WATER_DRINKING("Water Drinking"),
}
