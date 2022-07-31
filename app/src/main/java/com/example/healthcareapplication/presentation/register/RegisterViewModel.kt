package com.example.healthcareapplication.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.UserAcessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCases: UserAcessUseCases
) : ViewModel() {




    private val _email = mutableStateOf(RegisterState(
        email = "Enter email..."
    ))
    val email: State<RegisterState> = _email

    private val _name = mutableStateOf(RegisterState(
        name = "Enter name..."
    ))
    val name: State<RegisterState> = _name

    private val _password = mutableStateOf(RegisterState(
        password = "Enter password..."
    ))
    val password: State<RegisterState> = _password

    private val _confirmPassword = mutableStateOf(RegisterState(
        confirmPassword = "Enter confirmPassword..."
    ))
    val confirmPassword: State<RegisterState> = _confirmPassword


    private var newUser = User()

    init {

    }

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.CreateUser -> {
                viewModelScope.launch {
                    //newUser = User(email = _email, name = _name, password = _password)
                    //useCases.createUser(newUser)
                }

                /*if (!state.value.correctEmailFormat) {
                    return
                }*/
            }

            else -> {

            }
        }
    }
}
