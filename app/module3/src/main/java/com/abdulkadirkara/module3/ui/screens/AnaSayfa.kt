package com.abdulkadirkara.module3.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AnaSayfa(navController: NavController){

    LaunchedEffect(key1 = true) {
        Log.e("Anasayfa","LaunchedEffect çalıştı")
        //sayfa her göründüğünde çalışır
        //sayfaya geri dönüldüğünde çalışır
    }

    DisposableEffect(Unit) {
        Log.e("Anasayfa","DisposableEffect çalıştı")
        onDispose {
            Log.e("Anasayfa","DisposableEffect onDispose çalıştı")
            //sayfa giderse çalışır, görünmez olduğunda
        }
    }

    var sayac = remember { //bu state yapısı tüm ekranı view'ı yeniliyor değeri değiştikçe
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Anasayfa", fontSize = 30.sp)
        Text("Sayaç : ${sayac.value}", fontSize = 20.sp)
        Button(onClick = {
            sayac.value++
        }) {
            Text(text = "Tıkla")
        }
        Button(onClick = {
            val lastValue = if (sayac.value <= 10) sayac.value else "Kadir"
            navController.navigate("detaySayfa/${lastValue}") {
                popUpTo("anasayfa")
            }
        }) {
            Text(text = "Detay")
        }
    }
}