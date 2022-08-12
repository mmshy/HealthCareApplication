package com.example.healthcareapplication.domain.usecase.sleep

data class SleepUseCases(
    val getSleeps: GetSleeps,
    val getSleepById: GetSleepById,
    val getSleepDetails: GetSleepDetails,
    val addSleep: AddSleep,
    val addSleepDetail: AddSleepDetail,
    val updateSleep: UpdateSleep
)
