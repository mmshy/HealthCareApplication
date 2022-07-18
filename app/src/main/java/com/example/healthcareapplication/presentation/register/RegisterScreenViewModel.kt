package com.example.healthcareapplication.presentation.register

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    //use case
) : ViewModel() {

    private val _state = mutableStateOf<RegisterState>(RegisterState())
    val state: State<RegisterState> = _state


}
