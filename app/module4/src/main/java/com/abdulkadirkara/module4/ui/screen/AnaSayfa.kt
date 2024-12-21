package com.abdulkadirkara.module4.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abdulkadirkara.module4.data.entitiy.Kisiler
import com.abdulkadirkara.module4.ui.viewmodel.AnaSayfaViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(navController: NavController, viewModel: AnaSayfaViewModel) {
    val aramaYapiliyorMu = remember { mutableStateOf(false) }
    val textFieldAra = remember { mutableStateOf("") }
    val kisilerListesi = remember { mutableStateListOf<Kisiler>() }
    val scope = rememberCoroutineScope()//görüntelenmeyi sağlayacağımız yapı
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        kisilerListesi.add(Kisiler(1, "Ahmet", "123"))
        kisilerListesi.add(Kisiler(2, "Mehmet", "987"))
        kisilerListesi.add(Kisiler(3, "Ali", "111"))
        kisilerListesi.add(Kisiler(4, "Veli", "222"))
        kisilerListesi.add(Kisiler(5, "Can", "333"))
        kisilerListesi.add(Kisiler(6, "Canan", "444"))
        kisilerListesi.add(Kisiler(7, "Cem", "555"))
        kisilerListesi.add(Kisiler(8, "Ayşe", "666"))
        kisilerListesi.add(Kisiler(9, "Fatma", "777"))
        kisilerListesi.add(Kisiler(10, "Zeynep", "888"))
        kisilerListesi.add(Kisiler(11, "Hülya", "999"))
        kisilerListesi.add(Kisiler(12, "Aleyna", "000"))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (aramaYapiliyorMu.value)
                        TextField(
                            value = textFieldAra.value,
                            onValueChange = {
                                textFieldAra.value = it
                                ara(it)
                            },
                            label = { Text(text = "Ara") },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.Black,
                                unfocusedIndicatorColor = Color.White

                            )
                        )
                    else
                        Text(text = "Kişiler")
                },
                actions = {
                    if (aramaYapiliyorMu.value){
                        IconButton(onClick = { aramaYapiliyorMu.value = false }){
                            Icon(Icons.Rounded.Search, contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = true
                            textFieldAra.value = ""
                        }) {
                            Icon(Icons.Rounded.Close, contentDescription = "")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("kisiKayitSayfa")
                },
                content = {
                    Icon(Icons.Filled.Add, "Floating action button.")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(paddingValues)) {
            items(
                count = kisilerListesi.count(),
                itemContent ={//burdaki it indexleri vericez
                    val kisi = kisilerListesi[it]
                    Card(modifier = Modifier.padding(5.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().clickable {
                                val kisiJson = Gson().toJson(kisi)
                                navController.navigate("kisiDetaySayfa/${kisiJson}")
                            },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(text = kisi.kisi_ad, fontSize = 24.sp)
                                Text(text = kisi.kisi_tel)
                            }
                            IconButton(onClick = {
                                scope.launch {
                                    val snackbar = snackbarHostState.showSnackbar(
                                        message = "${kisi.kisi_ad} silinsin mi?",
                                        actionLabel = "Evet"
                                    )
                                    if (snackbar == SnackbarResult.ActionPerformed) {//Snackbar action oldu mu tıklanıldı mı
                                        sil(kisi.kisi_id)
                                    }
                                }
                            }) {
                                Icon(Icons.Rounded.Close, contentDescription = "",
                                    tint = Color.Gray
                                )
                            }
                        }
                    }
                }
            )
        }

    }
}

fun ara(aramaKelimesi: String){
    Log.e("Kisi Ara", aramaKelimesi)
}
fun sil(kisi_id: Int){

}