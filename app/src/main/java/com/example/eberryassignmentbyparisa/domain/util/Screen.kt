package com.example.eberryassignmentbyparisa.domain.util

sealed class Screen(val route: String) {
    object SearchScreen : Screen("search_screen")
    object TvShowsDetailsScreen : Screen("tv_shows_details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")

            }
        }
    }
}
