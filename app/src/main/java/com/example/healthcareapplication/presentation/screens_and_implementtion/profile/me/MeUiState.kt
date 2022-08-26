package com.example.healthcareapplication.presentation.screens_and_implementtion.profile.me

data class MeUiState(
    val isLoading: Boolean = false,
    val error: String = ""
) {

    var name: String = ""
}
