package com.example.healthcareapplication.presentation.screens_and_implementtion.goal.add_goal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.geometry.Size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalCard() {
    var mExpanded by remember { mutableStateOf(false) }

    val list = listOf("Lose Weight", "Gain Weight", "Drink")

    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = 46.dp,
                end = 46.dp,
                top = 45.dp,
                bottom = 60.dp
            ),
        shape = RoundedCornerShape(8.dp)
    ) {

        Text(
            text = "Add Sleep",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )

        Column(
            modifier = Modifier.padding(top = 45.dp)
        ) {

            // Create an Outlined Text Field
            // with icon and not expanded
            OutlinedTextField(
                value = mSelectedText,
                onValueChange = { mSelectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    }
                ,
                label = {Text("Goal Type")},
                trailingIcon = {
                    Icon(icon,"icon",
                        Modifier.clickable { mExpanded = !mExpanded })
                },
                readOnly = true
            )

            // Create a drop-down menu with list of cities,
            // when clicked, set the Text Field text as the city selected
            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})

            ) {
                list.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(text = label, color = Color.Black) },
                        onClick = {
                            mSelectedText = label
                            mExpanded = false
                        }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(29.dp))

        Box(
            modifier = Modifier
                .height(2.dp)
                .background(Color.LightGray)
                .width(271.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun preview() {
    GoalCard()
}