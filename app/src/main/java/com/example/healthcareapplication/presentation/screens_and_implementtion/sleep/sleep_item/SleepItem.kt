package com.example.healthcareapplication.presentation.sleep

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.healthcareapplication.R
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.presentation.ui.theme.Smoke
import java.text.SimpleDateFormat
import kotlin.time.Duration.Companion.hours

@Composable
fun SleepItem(
    sleep: SleepDetail,
    onCheckOutItem: (sleepDetail: SleepDetail) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(86.dp)
            .background(Smoke)
            .padding(24.dp, 0.dp)
    ) {
        Text(
            text = SimpleDateFormat("HH:mm").format(sleep.startTime.toDate()),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = sleep.status,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )

        if (sleep.status == "Sleeping") {
            IconButton(
                onClick = { onCheckOutItem(sleep) },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_done_24),
                    contentDescription = "icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

    }
}

@Composable
fun SleepItemTrick(
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(86.dp)
            .background(Smoke)
            .padding(24.dp, 0.dp)
    ) {
        Text(
            text = "hi",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = "donn",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
    }
}