package com.example.healthcareapplication.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Typography
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    secondary = LightBlue,
    tertiary = Smoke,
)

public val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = Blue,
    secondary = LightBlue,
    tertiary = Smoke,
    background = Color.White,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

private val Colors = Colors(
    primary = Blue,
    secondary = LightBlue,
    background = Smoke,
    surface = Smoke,
    error = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White,
    isLight = true,
    primaryVariant = Color.White,
    secondaryVariant = Color.White
)

val shapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp)
)

@Composable
fun HealthCareApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
          (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
//            (view.context as Activity).window.statusBarColor = Color.White.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
      colorScheme = colorScheme,
      typography = myTypography,
      content = content,
      shapes = shapes,
    )

//    androidx.compose.material.MaterialTheme(
//        colors = Colors,
//        myTypography1,
//        content = content
//    )
}

val myTypo = Typography(
    defaultFontFamily = Lato
)