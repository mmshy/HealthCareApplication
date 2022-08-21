package com.example.healthcareapplication.domain.model

import com.google.firebase.Timestamp

data class WaterDrinkingDetail (
    var id: String = "",
    var waterDrinkingId: String = "",
    var quantities: Int = 0,
    var time: Timestamp = Timestamp.now(),
)