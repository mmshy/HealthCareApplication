package com.example.healthcareapplication.presentation.screens_and_implementtion.forgotpassword;

data class ForgotPasswordState(
    val isLoading: Boolean = false,
    val correctEmailFormat: Boolean = false,
    val email: String = "",
    val error: String = ""
){

}


