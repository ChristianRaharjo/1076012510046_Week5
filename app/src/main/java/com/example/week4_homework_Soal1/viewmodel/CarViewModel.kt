package com.example.week4_homework_Soal1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week4_homework_Soal1.model.Car
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.example.week4_class.R

class CarViewModel : ViewModel() {

    private val initialCars = listOf(
        Car(1, "Tiggo 9 CSH", "PHEV", "Auto", "2024", "5,000 km", "Jakarta", "Rp 550.000.000", "SUV premium yang nyaman dan bertenaga.", R.drawable.tiggo),
        Car(2, "Honda CRV", "PETROL", "Auto", "2013", "15,200 km", "Bandung", "Rp 300.000.000", "Mobil SUV keluarga yang sangat handal.", R.drawable.crv),
        Car(3, "Toyota Yaris Cross", "HYBRID", "Auto", "2024", "30,500 km", "Surabaya", "Rp 400.000.000", "Hybrid SUV yang irit dan stylish.", R.drawable.yariscross),
        Car(4, "Daihatsu Xenia", "PETROL", "Manual", "2022", "28,000 km", "Semarang", "Rp 200.000.000", "Mobil MVP keluarga yang lega.", R.drawable.xenia),
        Car(5, "Toyota Yaris", "PETROL", "Auto", "2021", "52,400 km", "Semarang", "Rp 245.000.000", "The Toyota Yaris G AT is a sporty compact hatchback that punches above its weight class.", R.drawable.yaris),
        Car(6, "MG4 EV", "EV", "Auto", "2023", "12,000 km", "Jakarta", "Rp 600.000.000", "Mobil listrik dengan desain futuristik dan jarak tempuh jauh.", R.drawable.mg4),
        Car(7, "Daihatsu Ayla", "PETROL", "Manual", "2020", "45,000 km", "Bandung", "Rp 120.000.000", "City car yang sangat irit dan cocok untuk perkotaan.", R.drawable.ayla),
        Car(8, "Honda HRV", "PETROL", "Auto", "2022", "20,000 km", "Surabaya", "Rp 350.000.000", "Compact SUV populer dengan fitur lengkap.", R.drawable.hrv),
        Car(9, "Innova Reborn", "DIESEL", "Auto", "2019", "70,000 km", "Semarang", "Rp 400.000.000", "Mobil keluarga legendaris dengan mesin diesel tangguh.", R.drawable.reborn),
        Car(10, "Chery J5", "PETROL", "Auto", "2024", "1,000 km", "Jakarta", "Rp 450.000.000", "SUV compact terbaru dengan desain stylish.", R.drawable.j5)
    )

    private val _cars = MutableStateFlow(initialCars)
    val cars: StateFlow<List<Car>> = _cars.asStateFlow()

    fun toggleFavorite(carId: Int) {
        val updatedList = _cars.value.map { car ->
            if (car.id == carId) {
                car.copy(isFavorite = !car.isFavorite) 
            } else {
                car
            }
        }
        _cars.value = updatedList
    }

    fun getSavedCount(): Int {
        return _cars.value.count { it.isFavorite }
    }

    fun getCarById(id: Int): Car? {
        return _cars.value.find { it.id == id }
    }
}
