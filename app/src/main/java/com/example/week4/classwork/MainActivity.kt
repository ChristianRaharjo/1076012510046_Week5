//package com.example.week4.classwork
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.BackHandler
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.week4.classwork.ui.screen.BookingScreen
//import com.example.week4.classwork.ui.screen.test
//import com.example.week4.classwork.ui.theme.Week4ClassTheme
//import com.example.week4.classwork.viewmodel.latihanViewModel
//
//class MainActivity : ComponentActivity() {
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Week4ClassTheme {
//
//                val viewModel: latihanViewModel = viewModel()
//                val isFormOpen by viewModel.isFormOpen.collectAsState()
//
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Box(
//                        Modifier.padding(innerPadding)
//                    ) {
//                        if (isFormOpen) {
//                            BackHandler { viewModel.closeForm() }
//                            BookingScreen(
//                                onSubmit = viewModel::addBookingList,
//                                onCancel = viewModel::closeForm
//                            )
//                        } else {
//                            test()
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
