package com.example.healthcareapplication.domain.model

import java.time.LocalDate

class User (
    var userID          : String = "",
    var name            : String = "",
    var doB             : LocalDate = LocalDate.now(),
    var email           : String = "",
    var height          : Float = 0f,
    var weight          : Float= 0f,
    var heartBeat       : Int = 0,
    var bloodPressure   : Float= 0f,
    var password        : String = "",
    var gender          : Char = ' ',
    var bmi             : Float= 0f,
    var avatar          : String = ""
){

}
