package com.project.cse_234_hotel_booking_app.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.cse_234_hotel_booking_app.model.AuthViewModel
import com.project.cse_234_hotel_booking_app.pages.BookingSummaryPage
import com.project.cse_234_hotel_booking_app.pages.BookingsPage
import com.project.cse_234_hotel_booking_app.pages.ConfirmPage
import com.project.cse_234_hotel_booking_app.pages.FavoritesPage
import com.project.cse_234_hotel_booking_app.pages.FindHotelScreen
import com.project.cse_234_hotel_booking_app.pages.HomeScreen
import com.project.cse_234_hotel_booking_app.pages.HotelDetailsPage
import com.project.cse_234_hotel_booking_app.pages.PaymentPage
import com.project.cse_234_hotel_booking_app.pages.ProfilePage

@Composable
fun HomeNavGraph(navController: NavHostController,authViewModel: AuthViewModel) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavbarScreen.Home.route
    ) {
        composable(route = BottomNavbarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavbarScreen.Favorites.route) {
            FavoritesPage(navController = navController)
        }
        composable(route = BottomNavbarScreen.Bookings.route) {
            BookingsPage(navController = navController)
        }
        composable(route = BottomNavbarScreen.Profile.route) {
            ProfilePage(navController = navController,authViewModel = authViewModel
            )
        }
        detailsNavGraph(navController = navController)
    }
}



fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.FindHotel.route
    ) {
        composable(route = DetailsScreen.FindHotel.route) {
            FindHotelScreen(navController = navController)
        }
        composable(route = DetailsScreen.HotelDetails.route) {
            HotelDetailsPage(navController = navController)
        }
        composable(route = DetailsScreen.BookingSummary.route) {
            BookingSummaryPage(navController = navController)
        }
        composable(route = DetailsScreen.Payment.route) {
            PaymentPage(navController = navController)
        }
        composable(route = DetailsScreen.Confirm.route) {
            ConfirmPage(navController = navController)
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object FindHotel : DetailsScreen(route = "INFORMATION")
    object HotelDetails : DetailsScreen(route = "HOTELDETAILS")
    object Review : DetailsScreen(route = "REVIEW")
    object BookingSummary : DetailsScreen(route = "BOOKINGSUMMARY")
    object Payment : DetailsScreen(route = "PAYMENT")
    object Confirm : DetailsScreen(route = "CONFIRM")
}
