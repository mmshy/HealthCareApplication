package com.example.healthcareapplication.domain.model

import java.time.LocalDate
import java.time.LocalDate.now

class Sleep(
    //var sleepID     : String = "",
    var startTime   : LocalDate = now(),
    var finishTime  : LocalDate = now(),
    var sleepTime   : Float = 0F
) : HealthData() {

}