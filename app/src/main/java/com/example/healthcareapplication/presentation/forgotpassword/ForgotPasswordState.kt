package com.example.healthcareapplication.presentation.forgotpassword;

data class ForgotPasswordState(
    val isLoading: Boolean = false,
    val correctEmailFormat: Boolean = false,
    val email: String = "",
    val error: String = ""
){

}


