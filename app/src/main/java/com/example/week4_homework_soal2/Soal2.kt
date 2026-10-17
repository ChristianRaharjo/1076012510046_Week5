package com.example.week4_homework_soal2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week4_class.ui.theme.Week4ClassTheme
import com.example.week4_homework_soal2.view.DarkBg
import com.example.week4_homework_soal2.view.RosterScreen
import com.example.week4_homework_soal2.viewmodel.RosterViewModel

class Soal2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4ClassTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkBg)
                ) {
                    val viewModel: RosterViewModel = viewModel()
                    RosterScreen(viewModel = viewModel)
                }
            }
        }
    }
}
