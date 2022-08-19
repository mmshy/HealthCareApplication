package com.example.healthcareapplication.domain.usecase.goal

import com.example.healthcareapplication.domain.model.Goal
import com.example.healthcareapplication.domain.service.StorageServiceImpl
import com.example.healthcareapplication.presentation.screens_and_implementtion.goal.GoalStatus

class GetGoals(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(goalStatus: GoalStatus): List<Goal> {
        return repository.getGoals(goalStatus)
    }
}