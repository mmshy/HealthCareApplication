package com.example.healthcareapplication.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.healthcareapplication.domain.usecase.UserAccessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RegisterScreenViewModel @Inject constructor (
    private val useCases: UserAccessUseCases
) : ViewModel(){

    private val _state = mutableStateOf<RegisterState>(RegisterState())
    val state: State<RegisterState> = _state

    

}
