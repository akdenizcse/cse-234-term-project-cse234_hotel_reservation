package com.project.cse_234_hotel_booking_app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.project.cse_234_hotel_booking_app.CustomTextField
import com.project.cse_234_hotel_booking_app.R
import com.project.cse_234_hotel_booking_app.SimpleTopBar
import com.project.cse_234_hotel_booking_app.buttonlarge.fONTSPRINGDEMOOktahRoundMedium
import com.project.cse_234_hotel_booking_app.navigation.AuthScreen
import com.project.cse_234_hotel_booking_app.navigation.Graph

@Composable
fun LoginPage(navController: NavHostController) {

    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    val isButtonEnabled = email.isNotEmpty() && password.isNotEmpty()

    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "Welcome ",
                title2 = "Back",
                onBackClick = { navController.popBackStack() },
                additionalTitle = "Log in to continue your adventure with us"
            )
        },
        content = { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "E mail",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector1),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )


                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Password",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector2),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    )
                )

                TextButton(
                    onClick = {}) {
                    Text(
                        "Forgot Password?",
                        color = colorResource(id = R.color.primary_Color),
                        fontStyle = FontStyle.Italic
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp,)
                        .clip(RoundedCornerShape(50))
                        .height(61.dp),
                    onClick = {
                        navController.navigate(Graph.HOME) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.primary_Color),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Log In",
                        fontSize =  28.0.sp,
                        fontFamily = fONTSPRINGDEMOOktahRoundMedium,
                    )
                }


                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Don't have an account?")
                    TextButton(onClick = {
                        navController.navigate(AuthScreen.SignUp.route) {
                            popUpTo( AuthScreen.Main.route) { inclusive = false }
                        }
                    })
                    {
                        Text("Create", color = colorResource(id = R.color.primary_Color))
                    }
                }
            }
            }
        )
}