package com.example.week4.classwork.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CommentBank
import androidx.compose.material.icons.filled.Dataset
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week4.classwork.R
import com.example.week4.classwork.model.glitem
import com.example.week4.classwork.ui.Widget.BottomListSheet
import com.example.week4.classwork.viewmodel.latihanViewModel


@Composable
fun test(viewModel: latihanViewModel = viewModel()) {
    val galleryList by viewModel.galleryList.collectAsState()
    val bookingList by viewModel.bookingList.collectAsState()
    var isClicked by remember { mutableStateOf(false) }
    var showData by remember { mutableStateOf(false) }
    val image = if (isClicked) R.drawable._5 else R.drawable._2

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
            ) {
                Image(
                    painterResource(id = R.drawable._4),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(galleryList) { item ->
                    Box(
                        modifier = Modifier
                            .padding(start = 17.5.dp)
                            .width(120.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Image(
                            painterResource(id = item.imgRes),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(
                                    onClick = {
                                        isClicked = !isClicked
                                    }
                                )
                        )
                        Text(
                            text = item.name,
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Black)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Dual RTX 5080 Hadir, Fokus pada AI dan Komputasi Berat!",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "    Kehebohan baru saja melanda lingkungan akademis setelah potret bertajuk \"Anak - Anak Ambis Universitas Ciputra\" menjadi sorotan hangat. Mengiringi kemunculan file image_006de9.jpg yang menampilkan wajah-wajah penuh dedikasi tersebut, salah satu mahasiswa dikabarkan telah merakit sebuah PC monster yang ditenagai oleh konfigurasi ganda kartu grafis NVIDIA RTX 5080. Kehadiran setup kelas enthusiast yang sangat langka ini langsung memicu rasa penasaran besar di kalangan komunitas teknologi kampus yang tidak menyangka ada rig sekuat ini di lingkungan mereka.\n\n" +
                            "   Menariknya, sang pemilik dengan tegas membantah rumor bahwa hardware bernilai fantastis ini dirakit untuk sekadar kebutuhan rendering gambar atau desain dua dimensi standar. Sebagai gantinya, tenaga komputasi masif dari dua unit RTX 5080 tersebut difokuskan sepenuhnya untuk menjalankan eksperimen kecerdasan buatan tingkat lanjut, pengolahan model bahasa besar (LLM), dan manipulasi video berat. Konfigurasi ini memungkinkan pemrosesan algoritma machine learning kompleks secara lokal, serta mengeksekusi rendering proyek editing video beresolusi super tinggi dengan perangkat lunak profesional secara instan tanpa bottleneck performa sedikit pun.\n\n" +
                            "   Kawan-kawan sebayanya, yang juga merepresentasikan semangat kompetitif dan ambisius di kampus, mengaku takjub dengan dedikasi teknis di balik perakitan PC tersebut. Untuk menangani lonjakan daya dan suhu ekstrem dari dua kartu grafis monster generasi terbaru ini, sistem tersebut dipersenjatai dengan power supply berkapasitas raksasa dan solusi pendingin khusus yang presisi. Performa brutal yang dihasilkan membuat tugas-tugas komputasi data besar yang biasanya memakan waktu berhari-hari di laboratorium kampus kini dapat diselesaikan hanya dalam hitungan jam dari kamar tidur.\n\n" +
                            "   Langkah berani dengan membawa teknologi komputasi yang hampir setara dengan spesifikasi data center ke ruang lingkup personal ini diprediksi akan mengubah standar eksekusi proyek mahasiswa di masa mendatang. Selain membuktikan dominasi performa murni yang melampaui kebutuhan gaming, keberadaan rig dual RTX 5080 ini menjadi katalis bagi riset-riset teknologi independen, mengukuhkan bahwa batasan inovasi komputasi personal kini telah didobrak ke level yang sepenuhnya baru.\n\n",
                    modifier = Modifier
                        .weight(3f)
                        .padding(end = 8.dp),
                    fontSize = 15.sp
                )
                }
            Row {
                Box(Modifier.padding(16.dp).weight(2f)) {
                    Card(
                        modifier = Modifier.fillMaxSize(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(Modifier.fillMaxSize().padding(8.dp), Arrangement.SpaceEvenly, ){
                            Column(Modifier.fillMaxSize().weight(1f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                Icon(Icons.Filled.ThumbUp, "like", tint = Color.Red)
                                Text("124 likes")
                            }
                            Column(Modifier.fillMaxSize().weight(1f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                Icon(Icons.Filled.CommentBank, "like", tint = Color.Red)
                                Text("18 comments")
                            }
                            Column(Modifier.fillMaxSize().weight(1f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                Icon(Icons.Filled.Share, "like", tint = Color.Red)
                                Text("38 shares")
                            }
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier.padding(16.dp).align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ExtendedFloatingActionButton(
                icon = {Icon(Icons.Filled.Add, contentDescription = null)},
                text = {Text("Booking")},
                containerColor = Color.White,
                onClick = {viewModel.openForm()}
            )
            ExtendedFloatingActionButton(
                icon = {Icon(Icons.Filled.Dataset, contentDescription = null)},
                text = {Text("Data")},
                containerColor = Color.White,
                onClick = {viewModel.closeForm()}
            )
        }

        if(showData){
            BottomListSheet(
                dataBooking = bookingList,
                onDelete = viewModel::deleteBooking,
                onDismiss = {showData = false}
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun testPreview() {
    test()
}