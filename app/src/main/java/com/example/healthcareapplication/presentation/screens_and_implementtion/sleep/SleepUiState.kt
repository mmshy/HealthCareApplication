package com.example.healthcareapplication.presentation.screens_and_implementtion.sleep

import com.example.healthcareapplication.domain.model.BriefData
import com.example.healthcareapplication.domain.model.SleepDetail

data class SleepUiState (
    val greeting: String = "Hi, have a good day!",
    val briefData: List<BriefData> = emptyList(),
    val items: List<SleepDetail> = emptyList(),
    val data1: String = "1",
    val data2: String = "2",
    val data3: String = "3"
) {}