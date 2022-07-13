package com.example.healthcareapplication.domain.model

import java.time.LocalDate
import java.time.LocalDate.now

class SleepDetail (
    var startTime   : LocalDate = now(),
    var finishTime  : LocalDate = now(),
    var sleepTime   : Float = 0F
    ){

}