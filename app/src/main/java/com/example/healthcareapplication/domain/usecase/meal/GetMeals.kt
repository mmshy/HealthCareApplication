package com.example.healthcareapplication.domain.usecase.meal

import com.example.healthcareapplication.domain.service.StorageServiceImpl

class GetMeals(
    private val repository: StorageServiceImpl
) {
}