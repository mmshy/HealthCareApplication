package com.example.healthcareapplication.presentation.components.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun DashboardScreen() {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout(
        ) {
            val (title, body) = createRefs()

            Text(
                text = "Dashboard",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {}
            )

            Box(
                modifier = Modifier
                    .constrainAs(body) {
                        top.linkTo(title.bottom, 25.dp)
                    }
                    .fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.shark_sleep),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(83.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopCenter)
                        .zIndex(1F),
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.backgroud_image),
                        "",
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 160.dp, 16.dp, 0.dp)
                        .zIndex(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .height(138.dp)
                            .background(Color.White, RoundedCornerShape(8.dp)),
                    ) {
                        Text(text = "1")
                    }
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .height(138.dp)
                            .background(Color.White, RoundedCornerShape(8.dp)),
                    ) {
                        Text(text = "1")
                    }
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview() {
    DashboardScreen()
}