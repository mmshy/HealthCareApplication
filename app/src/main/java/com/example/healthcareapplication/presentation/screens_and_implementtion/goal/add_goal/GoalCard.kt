package com.example.healthcareapplication.presentation.screens_and_implementtion.goal.add_goal

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.geometry.Size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalCard(
    modifier: Modifier,
    viewModel: GoalCardViewModel = hiltViewModel()
) {

    val activity = unwrap(LocalContext.current) as AppCompatActivity

    val uiState by viewModel.state
    var startDate = uiState.startDate
    var endDate = uiState.endDate
    var name = uiState.name
    var content = uiState.content
    var type = uiState.goalType

    var mExpanded by remember { mutableStateOf(false) }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 42.dp,
                    bottom = 45.dp
                ),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Add Goal",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )

            Column(
                modifier = Modifier.padding(top = 32.dp, start = 20.dp, end = 20.dp)
            ) {

                // Create an Outlined Text Field
                // with icon and not expanded
                OutlinedTextField(
                    value = type.analyticsName,
                    onValueChange = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
                            mTextFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Goal Type") },
                    trailingIcon = {
                        Icon(icon, "icon",
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
                        .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })

                ) {
                    uiState.goalTypeList.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(text = label.analyticsName, color = Color.Black) },
                            onClick = {
                                viewModel.onTypeChange(label)
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
                    .background(MaterialTheme.colorScheme.onBackground)
                    .width(271.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = SimpleDateFormat("dd/MM/yy").format(startDate.toDate()),
                    onValueChange = {  },
                    label = { Text(text = "Start") },
                    modifier = Modifier
                        .width(141.dp),
                    trailingIcon = {
                        IconButton(onClick = { viewModel.showStartDatePicker(activity) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_calendar_today_24),
                                contentDescription = "icon"
                            )
                        }
                    }
                )
                OutlinedTextField(
                    value = SimpleDateFormat("dd/MM/yy").format(endDate.toDate()),
                    onValueChange = { },
                    label = { Text(text = "Finish") },
                    modifier = Modifier
                        .width(141.dp),
                    trailingIcon = {
                        IconButton(onClick = { viewModel.showEndDatePicker(activity) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_calendar_today_24),
                                contentDescription = "icon"
                            )
                        }
                    }
                )
            }

            OutlinedTextField(
                value = name,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text(text = "Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 27.dp)
            )

            OutlinedTextField(
                value = content.toString(),
                onValueChange = { viewModel.onContentChange(it.toInt()) },
                label = { Text(text = "Weight(gram)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 27.dp, bottom = 43.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            primaryBtn(
                onClick = { viewModel.addGoal() },
                modifier = Modifier
                    .width(155.dp)
                    .height(49.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                text = null,
                icon = R.drawable.ic_round_done_24
            )
        }
    }
}

private fun unwrap(context: Context): Activity? {
    var context: Context = context
    while (context !is Activity && context is ContextWrapper) {
        context = context.baseContext
    }
    return context as Activity
}

//@Composable
//@Preview(showBackground = true)
//fun preview() {
//    GoalCard()
//}