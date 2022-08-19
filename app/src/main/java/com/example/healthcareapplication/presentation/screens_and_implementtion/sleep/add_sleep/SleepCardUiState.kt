package com.example.healthcareapplication.presentation.screens_and_implementtion.sleep.add_sleep

import com.google.firebase.Timestamp

data class SleepCardUiState(
    val startTime: Timestamp = Timestamp.now(),
    val note: String = "Get Up!"
)
