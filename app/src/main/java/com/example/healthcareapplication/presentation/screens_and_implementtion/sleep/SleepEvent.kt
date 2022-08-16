package com.example.healthcareapplication.presentation.screens_and_implementtion.sleep

import com.example.healthcareapplication.domain.model.SleepDetail

sealed class SleepEvent {
    data class CheckOutItem(val sleepDetail: SleepDetail): SleepEvent()
}