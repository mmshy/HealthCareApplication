package com.example.healthcareapplication.presentation.screens_and_implementtion.profile.setting

import android.widget.Spinner
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun SettingScreen() {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        var showMenu by remember { mutableStateOf(false) }

        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            val (title, notification, permission, button) = createRefs()

            Text(
                text = "Setting",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {}
            )

            Column(
                modifier = Modifier.constrainAs(notification) {
                    top.linkTo(title.bottom, 26.dp)
                }
            ) {
                Text(
                    text = "Notification",
                    style = MaterialTheme.typography.labelSmall
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_notifications_24),
                        contentDescription = "icon",
                        modifier = Modifier.size(32.dp)
                    )
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "hi") },
                            onClick = { /*TODO*/ }
                        )
                    }
                }
            }

            Text(
                text = "Permission",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.constrainAs(permission) {
                    top.linkTo(notification.bottom, 51.dp)
                }
            )
        }
    }
}

@Composable
@Preview (showBackground = true)
fun preview() {
    SettingScreen()
}