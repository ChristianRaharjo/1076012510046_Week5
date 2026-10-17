package com.example.week4.soal2.model

data class Hero(
    val id: Int,
    val name: String,
    val rarity: String, 
    val heroClass: String, 
    val level: Int,
    val cp: Int,
    val currentHp: Int,
    val maxHp: Int,
    val currentMp: Int,
    val maxMp: Int,
    val imageResId: Int,
    val inSquad: Boolean = false
)
