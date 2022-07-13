package com.example.healthcareapplication.domain.model

import java.time.LocalDate
import java.time.LocalDate.now

class Goal(
    var goalId      : String = "",
    var name        : String = "",
    var startDate   : LocalDate = now(),
    var finishDate  : LocalDate = now(),
    var completeDate: LocalDate = now(),
    var result      : String = "",
    var status      : String = "",
    var description : String = "",
    var healthData  : HealthData
    ) {

}
