package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking

import com.example.healthcareapplication.domain.model.BriefData
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail

data class WaterDrinkingUiState(
    val greeting: String = "Hi, have a good day!",
    val briefData: List<BriefData> = emptyList(),
    val items: List<WaterDrinkingDetail> = emptyList(),
    val data1: String = "1",
    val data2: String = "2",
    val data3: String = "3",
    val showAddCard: Boolean = false
) {}