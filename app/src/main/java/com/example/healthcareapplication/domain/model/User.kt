package com.example.healthcareapplication.domain.model

import java.util.*

class User(
    var userID: String = "",
    var name: String = "",
    var doB: Date = Date(),
    var email: String = "",
    var height: Float = 0f,
    var weight: Float= 0f,
    var heartBeat: Int = 0,
    var bloodPressure: Float= 0f,
    var password: String = "",
    var gender: String = "",
    var bmi: Float= 0f,
    var avatar: String = ""
){

}

class InvalidUserException(message: String):Exception(message){

}
