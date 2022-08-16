package com.example.healthcareapplication.presentation.components.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.MeButton
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun MeScreen() {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout(
        ) {
            val (title, image, name, button) = createRefs()

            Text(
                text = "Info",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {}
            )

            Image(
                painterResource(id = R.drawable.shark_sleep),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
                    .constrainAs(image) {
                        top.linkTo(title.bottom, 28.dp)
                        centerHorizontallyTo(parent)
                    },
            )

            Text(
                text = "name",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(name) {
                        top.linkTo(image.bottom, 20.dp)
                    }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(button) {
                        top.linkTo(name.bottom, 60.dp)
                    }
                    .padding(16.dp, 0.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    MeButton(
                        onClick = { /*TODO*/ },
                        title = "Personal",
                        icon = R.drawable.ic_round_person_24
                    )

                    MeButton(
                        onClick = { /*TODO*/ },
                        title = "Health Data",
                        icon = R.drawable.ic_round_favorite_24
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 28.dp)
                ) {
                    MeButton(
                        onClick = { /*TODO*/ },
                        title = "Setting",
                        icon = R.drawable.ic_round_settings_24
                    )

                    MeButton(
                        onClick = { /*TODO*/ },
                        title = "Logout",
                        icon = R.drawable.ic_round_logout_24
                    )
                }
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun MeScreenPreview() {
    MeScreen()
}