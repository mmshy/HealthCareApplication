package com.example.healthcareapplication.domain.model

import java.time.LocalDate
import java.time.LocalDate.now

class Sleep(
    var totalTime       : Float = 0f,
    var sleepList       : MutableList<SleepDetail> = mutableListOf()
) : HealthData() {

}