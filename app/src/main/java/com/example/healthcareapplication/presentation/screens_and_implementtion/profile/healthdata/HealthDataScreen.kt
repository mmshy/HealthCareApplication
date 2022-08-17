package com.example.healthcareapplication.presentation.profile.healthdata

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.screens_and_implementtion.profile.healthdata.HealthDataItem
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
                .fillMaxSize()
        ) {
            val (title, info, button) = createRefs()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {}
            ) {
                Text(
                    text = "Health Data",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_person_24),
                        contentDescription = "icon",
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Column(
                modifier = Modifier
                    .constrainAs(info) {
                        top.linkTo(title.bottom, 45.dp)
                    }
            ) {
                HealthDataItem(
                    title = "Height",
                    value = "170cm",
                    icon = R.drawable.ic_round_person_24
                )
                Spacer(modifier = Modifier.height(4.dp))
                HealthDataItem(
                    title = "Weight",
                    value = "100kg",
                    icon = R.drawable.ic_round_person_24
                )
                Spacer(modifier = Modifier.height(4.dp))
                HealthDataItem(
                    title = "BMI",
                    value = "100",
                    icon = R.drawable.ic_round_person_24
                )
                Spacer(modifier = Modifier.height(4.dp))
                HealthDataItem(
                    title = "Blood Pressure",
                    value = "100",
                    icon = R.drawable.ic_round_person_24
                )
                Spacer(modifier = Modifier.height(4.dp))
                HealthDataItem(
                    title = "Heart Beat",
                    value = "100",
                    icon = R.drawable.ic_round_person_24
                )
            }

            primaryBtn(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(49.dp)
                    .constrainAs(button) {
                        bottom.linkTo(parent.bottom, 36.dp)
                    },
                text = "Reset",
                icon = null
            )
        }
    }
}

@Composable
@Preview (showBackground = true)
fun preview() {
    HealthDataScreen()
}