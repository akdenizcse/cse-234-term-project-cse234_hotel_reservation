package com.project.cse_234_hotel_booking_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.project.cse_234_hotel_booking_app.CustomTextField
import com.project.cse_234_hotel_booking_app.R
import com.project.cse_234_hotel_booking_app.SimpleTopBar
import com.project.cse_234_hotel_booking_app.buttonlarge.ButtonLarge
import com.project.cse_234_hotel_booking_app.buttonlarge.Design
import com.project.cse_234_hotel_booking_app.model.AuthViewModel
import com.project.cse_234_hotel_booking_app.navigation.AuthScreen
import com.project.cse_234_hotel_booking_app.navigation.DetailsScreen
import com.project.cse_234_hotel_booking_app.navigation.Graph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfilePage(navController: NavHostController,authViewModel: AuthViewModel) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "",
                title2 = "Profile",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) {
        ProfileScreen(navController = navController)
    }
}


@Composable
fun ProfileScreen(navController: NavHostController){
    var email by remember { mutableStateOf("onder123@hotmail.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp)
    ) {

        Spacer(modifier = Modifier.height(100.dp))
        // Profile Icon
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.component_1_vector),
                contentDescription = "Profile Image",
                modifier = Modifier
                    //.size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        // Email Field
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            label = "Email",
            textcolor = Color.Black,
            leadingIcon = painterResource(id = R.drawable.label_box_vector), // Replace with your email icon
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            labelFontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Log out Button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp,)
                .clip(RoundedCornerShape(50))
                .height(61.dp),
            onClick = {
                navController.navigate(DetailsScreen.Confirm.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.primary_Color),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Log Out",
                fontSize = 16.sp
            )
        }
    }
}