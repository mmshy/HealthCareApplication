package com.example.healthcareapplication.domain.model

import com.google.firebase.Timestamp
import java.time.LocalDate
import java.time.LocalDate.now

class Goal(
    var goalId      : String = "",
    var name        : String = "",
    var startDate   : Timestamp = Timestamp.now(),
    var finishDate  : Timestamp = Timestamp.now(),
    var completeDate: Timestamp = Timestamp.now(),
    var result      : String = "",
    var status      : String = "",
    var description : String = "",
    var healthData  : HealthData? = null
    ) {

}
