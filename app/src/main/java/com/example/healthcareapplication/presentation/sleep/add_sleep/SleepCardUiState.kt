package com.example.healthcareapplication.presentation.sleep.add_sleep

import com.google.firebase.Timestamp

data class SleepCardUiState(
//    val stateVisible: Boolean = false,
    val startTime: Timestamp = Timestamp.now(),
    val note: String = "Get Up!"
)
