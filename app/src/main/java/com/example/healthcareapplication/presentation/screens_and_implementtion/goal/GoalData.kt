package com.example.healthcareapplication.presentation.screens_and_implementtion.goal

import android.util.Log
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
import com.example.healthcareapplication.domain.model.Goal
import com.example.healthcareapplication.presentation.ui.theme.Gray
import java.util.*
import java.util.concurrent.TimeUnit

@Composable
fun GoalData(
    goal: Goal
) {

    var millionSeconds  = goal.finishDate.toDate().time - goal.startDate.toDate().time
    var timeGoal = TimeUnit.MILLISECONDS.toDays(millionSeconds) + 1
    var millionSeconds1  = goal.finishDate.toDate().time - Calendar.getInstance().timeInMillis
    var leftTime = TimeUnit.MILLISECONDS.toDays(millionSeconds1) + 1

    ConstraintLayout(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth()
    ) {
        val (image, goalTitle, progress, progressDetail, timeleftx) = createRefs()


        Box(
            modifier = Modifier
                .size(64.dp)
                .constrainAs(image) {
//                    start.linkTo(parent.start, margin = 10.dp)
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
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

        }

        Text(
            modifier = Modifier.constrainAs(goalTitle) {
                start.linkTo(image.end, margin = 20.dp)
            },
            text = goal.type,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(
            modifier = Modifier
                .width(200.dp)
                .background(Color.Cyan)
                .height(10.dp)
                .constrainAs(progress) {
                    start.linkTo(image.end, margin = 16.dp)
                    top.linkTo(goalTitle.bottom, margin = 15.dp)

                }
        )

        Text(
            modifier = Modifier
                .constrainAs(progressDetail) {
                    start.linkTo(image.end, margin = 20.dp)
                    top.linkTo(progress.bottom, margin = 10.dp)
                },
            text = "${goal.content}/${timeGoal} days",
            style = MaterialTheme.typography.titleLarge,
        )

        Text(
            modifier = Modifier
                .constrainAs(timeleftx) {
                    end.linkTo(parent.end, margin = 0.dp)
                    top.linkTo(progress.bottom, margin = 10.dp)
                },
            text = "$leftTime days left",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}


