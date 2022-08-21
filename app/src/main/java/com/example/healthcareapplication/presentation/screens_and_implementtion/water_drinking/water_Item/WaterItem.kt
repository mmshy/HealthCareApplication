package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.water_Item

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.presentation.ui.theme.Smoke
import java.text.SimpleDateFormat

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WaterItem(
    waterDrinkingDetail: WaterDrinkingDetail,
) {
    Log.d("water id: ", waterDrinkingDetail.waterDrinkingId)
    Log.d("item id: ", waterDrinkingDetail.id.toString())
    ConstraintLayout(

        modifier = Modifier
            .fillMaxSize()
            .height(86.dp)
            .background(Smoke)
            .padding(24.dp, 0.dp)
            .fillMaxWidth()

    ) {
        val (amount, time) = createRefs()
        Text(

            text = SimpleDateFormat("HH:mm").format(waterDrinkingDetail.time.toDate()),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(amount)
            {
                top.linkTo(parent.top, margin = 30.dp)
                start.linkTo(parent.start, margin = 10.dp)
            },
        )

        Spacer(modifier = Modifier.width(50.dp))

        Text(
            text = waterDrinkingDetail.quantities.toString() + "ml",
            style = MaterialTheme.typography.bodySmall,

            modifier =
            Modifier
                // .weight(1f),
                .constrainAs(time)
                {
                    top.linkTo(parent.top, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                }
                ,
            color = Color.Black
        )

    }
}