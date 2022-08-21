package com.example.healthcareapplication.presentation.screens_and_implementtion.goal

import com.example.healthcareapplication.domain.model.Goal

data class GoalUiState(
    val listGoal: List<Goal> = emptyList(),
    val status: GoalStatus = GoalStatus.DOING
)

enum class GoalStatus() {
    DOING,
    COMPLETE
}
