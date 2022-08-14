package com.example.healthcareapplication.presentation.screens_and_implementtion.screen

import com.example.healthcareapplication.R

sealed class MainScreens(
    val route: String,
    val title: String,
    val icon: Int
){
    object Dashboard : MainScreens(
        route = "dashboard",
        title = "Dashboard",
        icon = R.drawable.ic_round_dashboard_24
    )

    object Goal : MainScreens(
        route = "goal",
        title = "Goal",
        icon =R.drawable.ic_round_emoji_events_24
    )

    object Report : MainScreens(
        route = "report",
        title = "Report",
        icon =R.drawable.ic_round_leaderboard_24
    )

    object Me : MainScreens(
        route = "me",
        title = "Me",
        icon =R.drawable.ic_round_person_24
    )
}
