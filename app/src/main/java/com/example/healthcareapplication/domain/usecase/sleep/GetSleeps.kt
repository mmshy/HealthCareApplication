package com.example.healthcareapplication.domain.usecase.sleep

import com.example.healthcareapplication.domain.repository.SleepRepositoryImpl
import com.example.healthcareapplication.domain.repository.UserRepository

class GetSleeps(
    private val repository: SleepRepositoryImpl
) {

}