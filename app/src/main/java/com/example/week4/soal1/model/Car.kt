package com.example.week4.soal1.model

data class Car(
    val id: Int,
    val name: String,
    val type: String,
    val transmission: String,
    val year: String,
    val mileage: String,
    val location: String,
    val price: String,
    val description: String,
    val imageResId: Int,
    var isFavorite: Boolean = false
)
