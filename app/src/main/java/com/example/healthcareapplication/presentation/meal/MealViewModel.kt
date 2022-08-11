package com.example.healthcareapplication.presentation.meal

import androidx.lifecycle.ViewModel
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import javax.inject.Inject

class MealViewModel @Inject constructor(
    private val useCases: UserAccessUseCases
) : ViewModel()
{

}