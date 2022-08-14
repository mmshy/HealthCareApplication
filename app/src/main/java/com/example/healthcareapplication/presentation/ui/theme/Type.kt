package com.example.healthcareapplication.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.healthcareapplication.R

public val Lato = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_light, FontWeight.Light),
    Font(R.font.lato_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val myTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp,
        color = Color.Black
    ),
    bodySmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.Black
    ),
    headlineLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 64.sp,
        lineHeight = 77.sp,
        color = Color.Black
    ),
    headlineMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 38.sp,
        color = Color.Black
    ),
    headlineSmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 27.sp,
        color = Color.Black
    ),
    titleLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
        color = Color.Black
    ),
    titleMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 15.sp,
        lineHeight = 19.sp,
        letterSpacing = 0.sp,
        color = Color.Black
    ),
    labelSmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Gray
    ),
    labelMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 17.sp
    )
)

val myTypography1 = androidx.compose.material.Typography(
    h1 = TextStyle(fontFamily = Lato),
    button = TextStyle(fontFamily = Lato)
)