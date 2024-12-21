package com.abdulkadirkara.module6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun AnaSayfa(anasafaViewModel: AnaSayfaViewModel){
    val textFieldSayi1 = remember {
        mutableStateOf("")
    }
    val textFieldSayi2 = remember {
        mutableStateOf("")
    }
    val sonuc = anasafaViewModel.sonuc.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        sonuc.value?.let { Text(text = it, fontSize = 40.sp) }
        TextField(
            value = textFieldSayi1.value,
            onValueChange = { textFieldSayi1.value = it },
            label = { Text(text = "Sayi 1")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = textFieldSayi2.value,
            onValueChange = { textFieldSayi2.value = it },
            label = { Text(text = "Sayi 2")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(onClick = {
                anasafaViewModel.toplamaYap(textFieldSayi1.value,textFieldSayi2.value)
            }) {
                Text(text = "+")
            }
            Button(onClick = {
                anasafaViewModel.cikarmaYap(textFieldSayi1.value,textFieldSayi2.value)
            }) {
                Text(text = "-")
            }
            Button(onClick = {
                anasafaViewModel.carpmaYap(textFieldSayi1.value,textFieldSayi2.value)
            }) {
                Text(text = "*")
            }
            Button(onClick = {
                anasafaViewModel.bolmeYap(textFieldSayi1.value,textFieldSayi2.value)
            }) {
                Text(text = "/")
            }
        }
    }
}