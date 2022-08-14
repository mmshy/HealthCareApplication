package com.example.healthcareapplication.presentation.screens_and_implementtion.sleep

sealed class SleepEvent {
    data class CheckOutItem(val id: String): SleepEvent()
}