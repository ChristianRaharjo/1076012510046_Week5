package com.example.week4.soal1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week4.soal1.ui.theme.Week4HomeworkTheme
import com.example.week4.soal1.view.CarDetailScreen
import com.example.week4.soal1.view.CarListScreen
import com.example.week4.soal1.viewmodel.CarViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4HomeworkTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    CarApp()
                }
            }
        }
    }
}

enum class Screen {
    List, Detail
}

@Composable
fun CarApp() {
    val viewModel: CarViewModel = viewModel()
    var currentScreen by remember { mutableStateOf(Screen.List) }
    var selectedCarId by remember { mutableStateOf<Int?>(null) }

    when (currentScreen) {
        Screen.List -> {
            CarListScreen(
                viewModel = viewModel,
                onCarClick = { carId ->
                    selectedCarId = carId
                    currentScreen = Screen.Detail
                }
            )
        }
        Screen.Detail -> {
            selectedCarId?.let { id ->
                CarDetailScreen(
                    carId = id,
                    viewModel = viewModel,
                    onBackClick = {
                        currentScreen = Screen.List
                    }
                )
            }
        }
    }
}
