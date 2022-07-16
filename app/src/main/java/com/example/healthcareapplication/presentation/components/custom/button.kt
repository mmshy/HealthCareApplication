package com.example.healthcareapplication.presentation.components.custom

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun primaryBtn(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String,
    icon: Icon?,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(48.dp, 0.dp),
        shape = MaterialTheme.shapes.small,
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
        )
    }

}

@Composable
fun secondBtn(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String,
    icon: Icon?,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(48.dp, 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shape = MaterialTheme.shapes.small,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
        )
    }

}