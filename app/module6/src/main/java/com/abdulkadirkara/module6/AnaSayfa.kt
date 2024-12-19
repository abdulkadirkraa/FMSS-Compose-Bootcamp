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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun AnaSayfa(){
    val textFieldSayi1 = remember {
        mutableStateOf("")
    }
    val textFieldSayi2 = remember {
        mutableStateOf("")
    }
    val sonuc = remember {
        mutableStateOf("0")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = sonuc.value, fontSize = 40.sp)
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
                val alinanSayi1 = textFieldSayi1.value
                val alinanSayi2 = textFieldSayi2.value
                sonuc.value = (alinanSayi1.toInt() + alinanSayi2.toInt()).toString()
            }) {
                Text(text = "+")
            }
            Button(onClick = {
                val alinanSayi1 = textFieldSayi1.value
                val alinanSayi2 = textFieldSayi2.value
                sonuc.value = (alinanSayi1.toInt() - alinanSayi2.toInt()).toString()
            }) {
                Text(text = "-")
            }
            Button(onClick = {
                val alinanSayi1 = textFieldSayi1.value
                val alinanSayi2 = textFieldSayi2.value
                sonuc.value = (alinanSayi1.toInt() * alinanSayi2.toInt()).toString()
            }) {
                Text(text = "*")
            }
            Button(onClick = {
                val alinanSayi1 = textFieldSayi1.value
                val alinanSayi2 = textFieldSayi2.value
                if (alinanSayi2 != "0") {
                    sonuc.value = (alinanSayi1.toInt() / alinanSayi2.toInt()).toString()
                } else {
                    sonuc.value = "Hata 0'a bölünmez!"
                }

            }) {
                Text(text = "/")
            }
        }
    }
}