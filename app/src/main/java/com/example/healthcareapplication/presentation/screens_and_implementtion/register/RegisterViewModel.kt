package com.example.healthcareapplication.presentation.screens_and_implementtion.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthcareapplication.domain.model.InvalidUserException
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCases: UserAccessUseCases
) : ViewModel() {

    var navController: NavHostController? = null

    private val _uiState = mutableStateOf(RegisterUiState())
    val uiState: State<RegisterUiState> = _uiState


    init {

    }

    fun  onEmailChange(newValue: String) {
        _uiState.value = uiState.value.copy(
            email = newValue
        )
    }

    fun onNameChange (newValue: String) {
        _uiState.value = uiState.value.copy(
            name = newValue
        )
    }

    fun onPasswordChange(newValue: String) {
        _uiState.value = uiState.value.copy(
            password = newValue
        )
    }

    fun onConfirmPasswordhange(newValue: String) {
        _uiState.value = uiState.value.copy(
            confirmPassword = newValue
        )
    }



    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.CreateUser -> {
                viewModelScope.launch {
                    if (uiState.value.password == uiState.value.confirmPassword) {
                        try {
                            useCases.createAccount(
                                //check have we had enough info_s?
                                User(
                                    email = _uiState.value.email,
                                    name = _uiState.value.name,
                                    password = _uiState.value.password
                                )
                            )
                            // why this line doesnt work???
                            navController?.navigate(route = "home_graph")
                        } catch (e: InvalidUserException) {

                        }
                    }
                }
            }
            else -> {

            }
        }
    }
}
