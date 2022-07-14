package com.example.healthcareapplication.presentation.components

import com.example.healthcareapplication.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int
){
    object Dashboard : Screen(
        route = "dashboard",
        title = "Dashboard",
        icon = R.drawable.ic_round_dashboard_24
    )

    object Goal : Screen(
        route = "goal",
        title = "Goal",
        icon =R.drawable.ic_round_emoji_events_24
    )

    object Report : Screen(
        route = "report",
        title = "Report",
        icon =R.drawable.ic_round_leaderboard_24
    )

    object Me : Screen(
        route = "me",
        title = "Me",
        icon =R.drawable.ic_round_person_24
    )
}
