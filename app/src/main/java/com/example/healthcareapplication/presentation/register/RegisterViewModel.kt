package com.example.healthcareapplication.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.UserAccessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCases: UserAccessUseCases
) : ViewModel() {

    private val _uiState = mutableStateOf(RegisterState())
    val uiState: State<RegisterState> = _uiState

    private var newUser = User()

    init {

    }

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.CreateUser -> {
                viewModelScope.launch {

                    useCases.createAccount(
                        //check have we had enough info_s?
                        User(
                            email = _uiState.value.email,
                            name = _uiState.value.name,
                            password = _uiState.value.password
                        )
                    )
                }

            }

            is RegisterEvent.EnterEmail -> {
                _uiState.value = uiState.value.copy(
                    email = event.newEmail
                )
            }
            is RegisterEvent.EnterName -> {
                _uiState.value = uiState.value.copy(
                    name = event.newName
                )
            }

            is RegisterEvent.EnterPassword -> {
                _uiState.value = uiState.value.copy(
                    password = event.newPassword
                )
            }

            is RegisterEvent.EnterConfirmPassword -> {
                _uiState.value = uiState.value.copy(
                    confirmPassword = event.newConfirmPassword
                )
            }


            else -> {

            }
        }
    }
}
