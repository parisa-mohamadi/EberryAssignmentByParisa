package com.example.eberryassignmentbyparisa.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.util.Screen
import com.example.eberryassignmentbyparisa.presentation.search.SearchScreen
import com.example.eberryassignmentbyparisa.presentation.tvShowsdetails.TvShowsDetailsScreen


@Composable
fun AppNavigation(
) {
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = Screen.SearchScreen.route ){
        composable(
            route = Screen.SearchScreen.route
        ) {
           SearchScreen(navController = navController)
        }
        composable(
            route = Screen.TvShowsDetailsScreen.route
        ) {
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<SearchResponse>("selectedTvShow")
            LaunchedEffect(key1 = it){
                Log.d("TAG", "result :${result}")
            }
            TvShowsDetailsScreen(navController = navController)
        }
    }
}
