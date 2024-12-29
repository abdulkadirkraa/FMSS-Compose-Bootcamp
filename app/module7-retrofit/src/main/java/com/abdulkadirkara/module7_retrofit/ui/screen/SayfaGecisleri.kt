package com.abdulkadirkara.module7_retrofit.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abdulkadirkara.module7_retrofit.data.entity.Kisiler
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.AnasayfaViewModel
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.KisiDetayViewModel
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.KisiKayitViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anasayfaViewModel: AnasayfaViewModel,
                   kisiDetayViewModel: KisiDetayViewModel,
                   kisiKayitViewModel: KisiKayitViewModel
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            AnaSayfa(navController = navController, anasayfaViewModel = anasayfaViewModel)
        }
        composable("kisiKayitSayfa"){
            KisiKayitSayfa(kisiKayitViewModel = kisiKayitViewModel)
        }
        composable(
            "kisiDetaySayfa/{kisi}",
            arguments = listOf(navArgument("kisi") { type = NavType.StringType})
        ){
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json, Kisiler::class.java)
            KisiDetaySayfa(gelenKisi = nesne,kisiDetayViewModel = kisiDetayViewModel)
        }
    }
}