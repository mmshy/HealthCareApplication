package com.example.healthcareapplication.presentation.screens_and_implementtion.forgotpassword

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthcareapplication.domain.model.InvalidUserException
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel  @Inject constructor(
    private val useCases: UserAccessUseCases
) : ViewModel(){

    var navController: NavHostController? = null

    var uiState = mutableStateOf(ForgotPasswordState())

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onEvent(event: ForgotPasswordEvent) {
        when (event) {
            is ForgotPasswordEvent.ResendPassword -> {
                viewModelScope.launch {
                    if (true) {
                        try {
                            useCases.forgotPassword(uiState.value.email)
                            // no more home grapgh
                            //navController?.navigate(route = "home_graph")
                        } catch (e: InvalidUserException) {

                        }

                    }

                }

            }

            else -> {}
        }
    }
}