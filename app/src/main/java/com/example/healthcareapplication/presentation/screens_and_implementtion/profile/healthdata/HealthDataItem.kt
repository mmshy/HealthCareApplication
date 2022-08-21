package com.example.healthcareapplication.presentation.screens_and_implementtion.profile.healthdata

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.healthcareapplication.R

@Composable
fun HealthDataItem(
    title: String,
    value: String,
    icon: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "icon",
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.onTertiary
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
            )
        }
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
        )
    }
}