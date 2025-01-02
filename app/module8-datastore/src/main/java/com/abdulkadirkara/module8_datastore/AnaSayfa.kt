package com.abdulkadirkara.module8_datastore

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AnaSayfa(){

    val context = LocalContext.current
    val appPref = AppPref(context)

    val sonuc = remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = true) {
        CoroutineScope(Dispatchers.Main).launch {
            appPref.kayitAd("kadir")
            appPref.kayitYas(25)
            appPref.kayitBoy(1.75)
            appPref.kayitBekar(false)
            appPref.kayitListe(setOf("a","b","c","a"))

            appPref.silAd()

            val gelenAd = appPref.okuAd()
            Log.e("Gelen Ad", gelenAd)
            val gelenYas = appPref.okuYas()
            Log.e("Gelen Yas", gelenYas.toString())
            val gelenBoy = appPref.okuBoy()
            Log.e("Gelen Boy", gelenBoy.toString())
            val gelenBekar = appPref.okuBekar()
            Log.e("Gelen Bekar", gelenBekar.toString())
            val gelenListe = appPref.okuListe()
            Log.e("Gelen Liste", gelenListe.toString())

            var sayac = appPref.okuSayac()
            sonuc.intValue = ++sayac
            appPref.kayitSayac(sayac)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Açılış Sayısı : ${sonuc.intValue}",
            fontSize = 36.sp
        )
    }
}