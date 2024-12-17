package com.abdulkadirkara.module4.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KisiKayitSayfa(navController: NavController){
    val textFieldKisiAd = remember { mutableStateOf("") }
    val textFieldKisiTel = remember { mutableStateOf("") }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Kişi Kayıt") }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = textFieldKisiAd.value,
                onValueChange = { textFieldKisiAd.value = it },
                label = { Text(text = "Kişi Ad") },
                leadingIcon = {Icon(Icons.Default.Person, contentDescription = "")}
            )
             OutlinedTextField(
                 value = textFieldKisiTel.value,
                 onValueChange = { textFieldKisiTel.value = it },
                 label = { Text(text = "Kişi Tel") },
                 leadingIcon = {Icon(Icons.Default.Phone, contentDescription = "")}
             )
            Button(modifier = Modifier.size(width = 250.dp, height = 50.dp),
                onClick = {
                    kaydet(textFieldKisiAd.value, textFieldKisiTel.value, context = context)
                    navController.popBackStack()
            }) {
                Text(text = "Kaydet")
            }
        }

    }
}

fun kaydet(kisi_ad: String, kisi_tel: String, context: Context){
    Toast.makeText(context, "$kisi_ad - $kisi_tel", Toast.LENGTH_SHORT).show()
}