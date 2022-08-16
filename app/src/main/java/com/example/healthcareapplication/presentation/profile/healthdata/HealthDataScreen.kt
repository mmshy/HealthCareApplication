package com.example.healthcareapplication.presentation.profile.healthdata

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun HealthDataScreen() {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            val (title, image, name, info, button) = createRefs()
        }
    }
}

@Composable
@Preview (showBackground = true)
fun preview() {
    HealthDataScreen()
}