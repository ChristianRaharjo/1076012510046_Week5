package com.example.vpweek2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTravelScreen() {
    var tripFeedback by remember { mutableStateOf("") }
    var favoriteSpot by remember { mutableStateOf("") }
    var additionalNotes by remember { mutableStateOf("") }

    val containerBgColor = Color(0xFF2C3246)
    val inputBgColor = Color(0xFFD6E3F8)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Aurora Background",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )

        Card(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            colors = CardDefaults.cardColors(containerColor = containerBgColor),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Jaya Travel",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Aurora",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Tromsø, Norway",
                    fontSize = 15.sp,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = Color(0xFFFFB800),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "5.0",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                TravelInputField(
                    value = tripFeedback,
                    onValueChange = { tripFeedback = it },
                    placeholder = "What did you enjoy most about your trip?",
                    bgColor = inputBgColor
                )

                Spacer(modifier = Modifier.height(12.dp))

                TravelInputField(
                    value = favoriteSpot,
                    onValueChange = { favoriteSpot = it },
                    placeholder = "What was your favorite spot?",
                    bgColor = inputBgColor
                )

                Spacer(modifier = Modifier.height(12.dp))

                TravelInputField(
                    value = additionalNotes,
                    onValueChange = { additionalNotes = it },
                    placeholder = "Anything else you'd like to add?",
                    bgColor = inputBgColor
                )

                Spacer(modifier = Modifier.weight(1f))

                Box(modifier = Modifier.fillMaxWidth()) {
                    FloatingActionButton(
                        onClick = { /* Kosongkan onClick sesuai instruksi */ },
                        containerColor = inputBgColor,
                        contentColor = Color.Black,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TravelInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    bgColor: Color
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 13.sp,
                color = Color.DarkGray
            )
        },
        shape = RoundedCornerShape(14.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = bgColor,
            unfocusedContainerColor = bgColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMyTravel() {
    MyTravelScreen()
}