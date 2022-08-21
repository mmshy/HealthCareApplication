package com.example.healthcareapplication.domain.usecase.goal

import com.example.healthcareapplication.domain.model.Goal
import com.example.healthcareapplication.domain.service.StorageServiceImpl


class UpdateGoal(
    private val repository: StorageServiceImpl
) {
    suspend operator fun invoke(goal: Goal) {
        repository.updateGoal(goal)
    }
}