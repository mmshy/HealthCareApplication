package com.example.healthcareapplication.presentation.components.custom

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun primaryBtn(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String?,
    icon: Int?,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(48.dp, 0.dp),
        shape = MaterialTheme.shapes.small,
    ) {
        if (text != null) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
            )
        }

        if (icon != null) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }

}

@Composable
fun secondBtn(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String,
    icon: Int?,
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
            color = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
fun primaryBtnNoPadding(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String?,
    icon: Int?,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
    ) {
        if (text != null) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
            )
        }

        if (icon != null) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }

}

@Composable
fun secondBtnNoPadding(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String,
    icon: Int?,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shape = MaterialTheme.shapes.small,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        if (icon != null) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }



}

@Composable
fun DashboardBtn(
    onClick: () -> Unit,
    title: String,
    icon: Int,
) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(138.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Click!",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Icon(
            painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
//@Preview
fun MeButton(
    onClick: () -> Unit,
    title: String,
    icon: Int,
) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}