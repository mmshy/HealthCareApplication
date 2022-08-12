package com.example.healthcareapplication.domain.model

import com.google.firebase.Timestamp
import java.util.Date

class SleepDetail(
//    var id: String = "",
    var sleepId: String = "",
    var startTime: Timestamp = Timestamp.now(),
    var finishTime: Timestamp = Timestamp.now(),
    var sleepTime: Float = 0F,
    var status: String = "Sleeping"
) {

}