package com.example.healthcareapplication.presentation.screens_and_implementtion.profile.me

import com.example.healthcareapplication.presentation.screens_and_implementtion.register.RegisterEvent

sealed class MeEvent {
    object onLogOut :MeEvent()
    object onPersonalClick : MeEvent()
    object onHealthDataClick : MeEvent()
    object onSettingClick : MeEvent()
}