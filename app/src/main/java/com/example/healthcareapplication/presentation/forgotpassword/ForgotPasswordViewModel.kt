package com.example.healthcareapplication.presentation.forgotpassword

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthcareapplication.domain.model.InvalidUserException
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.UserAccessUseCases
import com.example.healthcareapplication.presentation.register.RegisterEvent
import com.example.healthcareapplication.presentation.register.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel  @Inject constructor(
    private val useCases: UserAccessUseCases
) : ViewModel(){
    var navController: NavHostController? = null

    private val _uiState = mutableStateOf(ForgotPasswordState())
    val uiState: State<ForgotPasswordState> = _uiState

    fun onEvent(event: ForgotPasswordEvent) {
        when (event) {
            is ForgotPasswordEvent.ResendPassword -> {
                viewModelScope.launch {
                    if (true) {
                        try {
                            useCases.forgotPassword(_uiState.value.email)
                            // no more home grapgh
                            //navController?.navigate(route = "home_graph")
                        } catch (e: InvalidUserException) {

                        }

                    }

                }


            }

            is ForgotPasswordEvent.EnterEmail -> {
                _uiState.value = uiState.value.copy(
                    email = event.newEmail
                )
            }

            else -> {}
        }
    }
}