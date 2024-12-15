package com.abdulkadirkara.module3.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun DetaySayfa(sayac: String){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Detay Sayfa", fontSize = 30.sp)
        Text(sayac, fontSize = 20.sp)

        BackHandler(enabled = true) {//geri dönüş pasif, çalışmaz
            //false ise de geçiş var
        }

    }
}