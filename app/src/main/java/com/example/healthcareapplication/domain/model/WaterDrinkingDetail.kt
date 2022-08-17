package com.example.healthcareapplication.domain.model

import com.google.firebase.Timestamp

data class WaterDrinkingDetail (
    var id: String = "",
    var waterDrinkingId: String = "",
    var quantities: Float = 0F,
    var time: Timestamp = Timestamp.now(),
)