package com.example.week4_class.model

import android.graphics.Bitmap

data class booking (
    val name:String,
    val email:String,
    val photo: Bitmap? = null
)