package com.example.eventhandlingstate

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PemesananTiket() {
    val context = LocalContext.current
    val hargaTiket = 50000
    var jumlahTiket by remember { mutableStateOf(1) }
    val totalBayar = hargaTiket * jumlahTiket
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(                                                         //judul
            text = "PEMESANAN TIKET",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D47A1)
        )
        Spacer(Modifier.height(20.dp))
        Column(                                                      //harga tiket
            modifier = Modifier.fillMaxWidth()
                .border(2.dp, Color(0xFF0D47A1), RoundedCornerShape(10.dp))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Harga Tiket", fontSize = 18.sp)
            Text("Rp $hargaTiket", fontSize = 22.sp)
        }
        Spacer(Modifier.height(12.dp))
        Column(                                                      //jumlah tiket
            modifier = Modifier.fillMaxWidth()
                .border(2.dp, Color(0xFF0D47A1), RoundedCornerShape(10.dp))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Jumlah Tiket", fontSize = 18.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick = { if (jumlahTiket > 1) jumlahTiket-- },
                    colors = ButtonDefaults.buttonColors(Color(0xFF0D47A1))
                ) {
                    Text("-")
                }
                Text("$jumlahTiket", fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 24.dp))
                Button(
                    onClick = { jumlahTiket++ },
                    colors = ButtonDefaults.buttonColors(Color(0xFF0D47A1))
                ) {
                    Text("+")
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        Column(                                                          //total bayar
            modifier = Modifier.fillMaxWidth()
                .border(2.dp, Color(0xFF0D47A1), RoundedCornerShape(10.dp))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Total Bayar", fontSize = 18.sp)
            Text("Rp $totalBayar", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(20.dp))
        Button(                                                         //tombol reset
            onClick = {
                jumlahTiket = 1
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("↻ RESET")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(                                                          //tombol konfirmasi
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Konfirmasi Pemesanan Tiket")
        }
    }
}