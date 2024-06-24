package com.project.cse_234_hotel_booking_app.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.cse_234_hotel_booking_app.pages.LoginPage
import com.project.cse_234_hotel_booking_app.pages.MainContent
import com.project.cse_234_hotel_booking_app.pages.SignUpPage

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Main.route
    ) {
        composable(route = AuthScreen.Main.route) {
            MainContent(
                onClick = {
                    navController.navigate(AuthScreen.Login.route)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            )
        }
        composable(route = AuthScreen.Login.route) {
            LoginPage(
                navController = navController
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpPage(navController = navController)
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Main : AuthScreen(route = "MAIN")
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}