package com.project.cse_234_hotel_booking_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.cse_234_hotel_booking_app.HomePage
import com.project.cse_234_hotel_booking_app.model.AuthViewModel

@Composable
fun RootNavigationGraph(navController: NavHostController,authViewModel: AuthViewModel) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController, authViewModel = authViewModel)
        composable(route = Graph.HOME) {
            HomePage(authViewModel = authViewModel)
        }
    }
}


object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
