package com.example.healthcareapplication.presentation.login

import androidx.lifecycle.ViewModel
import com.example.healthcareapplication.domain.usecase.UserAcessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: UserAcessUseCases
): ViewModel() {
    init {
        /*TODO*/
    }
}