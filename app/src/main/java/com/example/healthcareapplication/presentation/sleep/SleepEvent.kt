package com.example.healthcareapplication.presentation.sleep

import com.example.healthcareapplication.domain.model.SleepDetail

sealed class SleepEvent {
    data class CheckOutItem(val sleepDetail: SleepDetail): SleepEvent()
}