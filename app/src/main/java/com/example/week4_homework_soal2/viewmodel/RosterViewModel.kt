package com.example.week4_homework_soal2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week4_class.R
import com.example.week4_homework_soal2.model.FilterItem
import com.example.week4_homework_soal2.model.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RosterViewModel : ViewModel() {

    private val _heroes = MutableStateFlow(
        listOf(
            Hero(1, "Alistair", "MYTHIC", "High Templar", 50, 5600, 1650, 1800, 650, 800, R.drawable.paladin),
            Hero(2, "Theresa", "MYTHIC", "Divine Oracle", 49, 5480, 1100, 1200, 2100, 2400, R.drawable.cleric),
            Hero(3, "Vespera", "MYTHIC", "Shadowblade", 48, 5350, 890, 950, 410, 600, R.drawable.rogue),
            Hero(4, "Elaria", "MYTHIC", "Archmage", 48, 5120, 450, 600, 1950, 2000, R.drawable.archmage, inSquad = true),
            Hero(5, "Grom", "EPIC", "Berserker", 45, 4800, 2000, 2200, 100, 150, R.drawable.berserker)
        )
    )
    val heroes: StateFlow<List<Hero>> = _heroes.asStateFlow()
    
    private val _filters = MutableStateFlow(
        listOf(
            FilterItem(1, "All", 14),
            FilterItem(2, "Berserker", 2),
            FilterItem(3, "Archmage", 3),
            FilterItem(4, "Rogue", 4)
        )
    )
    val filters: StateFlow<List<FilterItem>> = _filters.asStateFlow()

    private val _selectedFilterId = MutableStateFlow(1)
    val selectedFilterId: StateFlow<Int> = _selectedFilterId.asStateFlow()

    fun selectFilter(filterId: Int) {
        _selectedFilterId.value = filterId
    }
}
