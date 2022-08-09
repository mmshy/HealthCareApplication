package com.example.healthcareapplication.domain.service

import com.example.healthcareapplication.domain.model.Sleep

interface StorageService {

    fun addListener()
    fun removeListener()

//    Sleep
    fun getSleepById(id: String)
    fun addSleep(sleep: Sleep)


}