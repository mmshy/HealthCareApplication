package com.example.healthcareapplication.presentation.sleep

sealed class SleepEvent {
    data class CheckOutItem(val id: String): SleepEvent()
}