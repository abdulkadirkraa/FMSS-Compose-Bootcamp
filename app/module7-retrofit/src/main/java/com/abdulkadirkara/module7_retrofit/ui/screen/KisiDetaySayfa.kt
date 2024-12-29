package com.abdulkadirkara.module7_retrofit.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.abdulkadirkara.module7_retrofit.data.entity.Kisiler
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.KisiDetayViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KisiDetaySayfa(gelenKisi: Kisiler, kisiDetayViewModel: KisiDetayViewModel){
    val tfKisiAd = remember { mutableStateOf("") }
    val tfKisiTel = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        tfKisiAd.value = gelenKisi.kisi_ad
        tfKisiTel.value = gelenKisi.kisi_tel
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Kişi Detay") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = tfKisiAd.value,
                onValueChange = {tfKisiAd.value = it},
                label = { Text(text = "Kişi Ad") })

            TextField(
                value = tfKisiTel.value,
                onValueChange = {tfKisiTel.value = it},
                label = { Text(text = "Kişi Tel") })

            Button(onClick = {
                kisiDetayViewModel.guncelle(gelenKisi.kisi_id,tfKisiAd.value,tfKisiTel.value)
            }) {
                Text(text = "GÜNCELLE")
            }
        }
    }
}