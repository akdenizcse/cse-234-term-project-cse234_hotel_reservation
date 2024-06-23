package com.project.cse_234_hotel_booking_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.project.cse_234_hotel_booking_app.CustomTextField
import com.project.cse_234_hotel_booking_app.R
import com.project.cse_234_hotel_booking_app.SimpleTopBar
import com.project.cse_234_hotel_booking_app.buttonlarge.ButtonLarge
import com.project.cse_234_hotel_booking_app.buttonlarge.Design
import com.project.cse_234_hotel_booking_app.buttonlarge.fONTSPRINGDEMOOktahRoundMedium

@Composable
fun HomeScreen(navController: NavHostController){
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var date2 by remember { mutableStateOf("") }
    var counter by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        val imagePainter = painterResource(id = R.drawable.card_image)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome, plan your journey!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.primary_Color),
                //modifier = Modifier.padding(8.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            CustomTextField(
                value = location,
                onValueChange = { location = it},
                placeholder = "Example: Antalya",
                leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                label = "Where?",
                textcolor = Color.Black,
                labelFontWeight = FontWeight.ExtraBold,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTextField(
                    value = date,
                    onValueChange = { date = it },
                    placeholder = "DD/MM/YY",
                    leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                    label = "Check-in",
                    textcolor = Color.Black,
                    labelFontWeight = FontWeight.ExtraBold,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                CustomTextField(
                    value = date2,
                    onValueChange = { date2 = it },
                    placeholder = "DD/MM/YY",
                    leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                    label = "Check-out",
                    textcolor = Color.Black,
                    labelFontWeight = FontWeight.ExtraBold,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = counter,
                onValueChange = { counter = it },
                placeholder = "1",
                leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                label = "Guest",
                textcolor = Color.Black,
                labelFontWeight = FontWeight.ExtraBold,
                trailingIcon = {
                    Row {
                        IconButton(onClick = { /* Decrease guest count */ }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Decrease")
                        }
                        IconButton(onClick = { /* Increase guest count */ }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(64.dp))

            ButtonLarge(
                onClick = {},
                text = "Find",
                design = Design.Primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .clip(RoundedCornerShape(50))
            )
            }
        }
}