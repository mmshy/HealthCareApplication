package com.example.healthcareapplication.presentation.screens_and_implementtion.meal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.MealDetail

@Composable
//@Preview (showBackground = true)
fun MealItem(
    mealDetails: List<MealDetail>,
    modifier: Modifier
) {
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .height(65.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = mealDetails[0].mealType.analyticsName,
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "${mealDetails[0].calories}kcal",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall
                )

            }

            LazyColumn() {
                items(mealDetails) { mealDetail ->
                    Row(
                        modifier = Modifier
                            .height(65.dp)
                            .background(MaterialTheme.colorScheme.onBackground)
                            .fillMaxWidth()
                            .padding(20.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = mealDetail.foodCategory.name,
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = mealDetail.weight.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.Black
                        )
                        Text(
                            text = mealDetail.calories.toString(),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

        }
    }

}