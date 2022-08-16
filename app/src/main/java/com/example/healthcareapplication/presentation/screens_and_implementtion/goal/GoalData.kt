package com.example.healthcareapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.ui.theme.Gray

@Composable
fun GoalData(
    title: String?,
    goal: Int,
    time: Int,
    timeLeft: Int
) {
    ConstraintLayout(
    ) {
        val (image, goalTitle, progress, progressDetail, timeleftx) = createRefs()


        Box(
            modifier = Modifier
                .size(90.dp)
                .constrainAs(image) {
                    start.linkTo(parent.start, margin = 10.dp)
                }
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape,
                    clip = true
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

        }

        if (title != null) {
            Text(
                modifier = Modifier.constrainAs(goalTitle) {
                    start.linkTo(image.end, margin = 20.dp)
                },
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier
                .width(200.dp)
                .background(Color.Cyan)
                .height(10.dp)
                .constrainAs(progress) {
                    start.linkTo(image.end, margin = 20.dp)
                    top.linkTo(goalTitle.bottom, margin = 15.dp)

                }
        )



        Text(
            modifier = Modifier
                .constrainAs(progressDetail) {
                    start.linkTo(image.end, margin = 20.dp)
                    top.linkTo(progress.bottom, margin = 10.dp)
                },
            text = "$goal/$time",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )




        Text(
            modifier = Modifier
                .constrainAs(timeleftx) {
                    end.linkTo(parent.end, margin = 10.dp)
                    top.linkTo(progress.bottom, margin = 10.dp)
                },
            text = "$timeLeft",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )


    }
}


