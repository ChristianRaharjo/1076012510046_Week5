package com.example.week4.soal2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4.soal2.model.FilterItem
import com.example.week4.soal2.model.Hero
import com.example.week4.soal2.viewmodel.RosterViewModel
import com.example.week4.classwork.R

val DarkBg = Color(0xFF16161E)
val CardBg = Color(0xFF1F1F2E)
val AccentYellow = Color(0xFFFFB703)
val BorderColor = Color(0xFF33334D)
val TextGray = Color(0xFFA0A0B0)
val MythicPink = Color(0xFFE91E63)
val HpRed = Color(0xFFFF3B30)
val MpBlue = Color(0xFF007AFF)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RosterScreen(viewModel: RosterViewModel) {
    val heroes by viewModel.heroes.collectAsState()
    val filters by viewModel.filters.collectAsState()
    val selectedFilterId by viewModel.selectedFilterId.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Party Roster",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Guild Vanguard • 14 Heroes Available",
                    color = TextGray,
                    fontSize = 12.sp
                )
            }
            
            Box(
                modifier = Modifier
                    .border(1.dp, AccentYellow, RoundedCornerShape(16.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = AccentYellow,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Expedition",
                        color = AccentYellow,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, AccentYellow, RoundedCornerShape(16.dp))
                .background(Color(0xFF25253A), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(Color.Green, RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "EXPEDITION SQUAD (3/4)",
                            color = TextGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚔️", fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "14750 CP",
                            color = AccentYellow,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        SquadAvatar(R.drawable.rogue)
                        SquadAvatar(R.drawable.archmage)
                        SquadAvatar(R.drawable.paladin)
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .border(1.dp, BorderColor, RoundedCornerShape(8.dp))
                                .background(CardBg, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add", tint = TextGray)
                        }
                    }
                    
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentYellow),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Deploy ⚡", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search by hero name, class, or rarity...", color = TextGray) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = TextGray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = CardBg,
                unfocusedContainerColor = CardBg,
                disabledContainerColor = CardBg,
                unfocusedIndicatorColor = BorderColor,
                focusedIndicatorColor = AccentYellow
            ),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            filters.forEach { filter ->
                FilterChip(
                    filter = filter,
                    isSelected = filter.id == selectedFilterId,
                    onClick = { viewModel.selectFilter(filter.id) }
                )
            }
            
            Box(
                modifier = Modifier
                    .background(Color(0xFF2A2A3E), RoundedCornerShape(16.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text("Sort: Power", color = AccentYellow, fontSize = 12.sp)
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(heroes) { hero ->
                HeroCard(hero)
            }
        }
    }
}

@Composable
fun FilterChip(filter: FilterItem, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .border(
                1.dp,
                if (isSelected) AccentYellow else BorderColor,
                RoundedCornerShape(16.dp)
            )
            .background(
                if (isSelected) Color(0xFF3B2A0F) else CardBg,
                RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "${filter.name} (${filter.count})",
            color = if (isSelected) AccentYellow else TextGray,
            fontSize = 12.sp
        )
    }
}

@Composable
fun SquadAvatar(imageResId: Int) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .border(1.dp, Color.White, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun HeroCard(hero: Hero) {
    val cardBorder = if (hero.inSquad) AccentYellow else BorderColor
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, cardBorder, RoundedCornerShape(16.dp))
            .background(CardBg, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(modifier = Modifier.background(MythicPink.copy(alpha = 0.2f), RoundedCornerShape(4.dp)).padding(horizontal = 6.dp, vertical = 2.dp)) {
                        Text(hero.rarity, color = MythicPink, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                    
                    val classColor = if(hero.heroClass.contains("Archmage") || hero.heroClass.contains("Oracle")) Color(0xFF00C853) else if(hero.heroClass.contains("Shadowblade")) Color(0xFFAA00FF) else AccentYellow
                    Box(modifier = Modifier.background(classColor.copy(alpha = 0.2f), RoundedCornerShape(4.dp)).padding(horizontal = 6.dp, vertical = 2.dp)) {
                        Text(hero.heroClass, color = classColor, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⚔️", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("${hero.cp} CP", color = AccentYellow, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    
                    if (hero.inSquad) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(modifier = Modifier.background(AccentYellow.copy(alpha = 0.2f), RoundedCornerShape(4.dp)).border(1.dp, AccentYellow, RoundedCornerShape(4.dp)).padding(horizontal = 6.dp, vertical = 2.dp)) {
                            Text("IN SQUAD", color = AccentYellow, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .border(2.dp, MythicPink, RoundedCornerShape(12.dp))
                        .background(Color.White, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Image(
                        painter = painterResource(id = hero.imageResId),
                        contentDescription = hero.name,
                        modifier = Modifier.fillMaxSize().padding(4.dp),
                        contentScale = ContentScale.Fit
                    )
                    
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(topStart = 8.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                        Text("Lvl ${hero.level}", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(hero.name, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Expand", tint = TextGray)
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    StatusBar("HP", hero.currentHp, hero.maxHp, HpRed)
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    StatusBar("MP", hero.currentMp, hero.maxMp, MpBlue)
                }
            }
        }
    }
}

@Composable
fun StatusBar(label: String, currentValue: Int, maxValue: Int, color: Color) {
    val fraction = currentValue.toFloat() / maxValue.toFloat()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(label, color = TextGray, fontSize = 10.sp, modifier = Modifier.width(24.dp))
        
        Box(
            modifier = Modifier
                .weight(1f)
                .height(6.dp)
                .background(Color(0xFF2A2A3E), RoundedCornerShape(3.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction)
                    .height(6.dp)
                    .background(color, RoundedCornerShape(3.dp))
            )
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        Text("$currentValue / $maxValue", color = TextGray, fontSize = 10.sp, modifier = Modifier.width(60.dp))
    }
}
