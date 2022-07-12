package com.example.healthcareapplication.domain.model

import java.time.LocalDate
import java.time.LocalDate.now

open class HealthData (
    var id          : String = "",
    var updateDate  : LocalDate = now()
){

}