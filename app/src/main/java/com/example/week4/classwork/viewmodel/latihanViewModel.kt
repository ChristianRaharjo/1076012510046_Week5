package com.example.week4.classwork.viewmodel

import android.R.id.list
import android.graphics.Bitmap
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.week4.classwork.R
import com.example.week4.classwork.model.booking
import com.example.week4.classwork.model.glitem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Collections.list
import kotlin.collections.toMutableList

class latihanViewModel : ViewModel(){
    private val _galleryList = MutableStateFlow(
        listOf(
            glitem(R.drawable._1, "Ngantok Bos"),
            glitem(R.drawable._2, "5080 x 2"),
            glitem(R.drawable._3, "Hi Gesss"),
            glitem(R.drawable._4, "")
        )
    )
    val galleryList: StateFlow<List<glitem>> = _galleryList.asStateFlow()

    private val _bookingList = MutableStateFlow<List<booking>>(emptyList())
    val bookingList: StateFlow<List<booking>> = _bookingList.asStateFlow()

    fun addBookingList(name: String, email: String, photo: Bitmap?) {
        _bookingList.update { it + booking(name, email, photo) }
        _isFormOpen.value = false
    }


    fun deleteBooking(index: Int) {
        _bookingList.update { list ->
            if (index in list.indices) list.toMutableList().apply { removeAt(index) }
            else list
        }
    }


    //Buka Tutup Form Booking Logic
    private val _isFormOpen = MutableStateFlow(false)
    val isFormOpen: StateFlow<Boolean> = _isFormOpen.asStateFlow()

    fun openForm() {
        _isFormOpen.value = true
    }

    fun closeForm() {
        _isFormOpen.value = false
    }
}