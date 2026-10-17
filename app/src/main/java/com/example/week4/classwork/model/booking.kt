package com.example.week4.classwork.model

import android.graphics.Bitmap

data class booking (
    val name:String,
    val email:String,
    val photo: Bitmap? = null
)