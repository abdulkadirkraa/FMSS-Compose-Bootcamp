package com.abdulkadirkara.module4.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abdulkadirkara.module4.data.entitiy.Kisiler
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "anasayfa") {
        composable("anasayfa"){
            AnaSayfa(navController)
        }
        composable("kisiKayitSayfa"){
            KisiKayitSayfa(navController)
        }
        composable("kisiDetaySayfa/{kisi}",
            arguments = listOf(
                navArgument("kisi"){type = NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json, Kisiler::class.java)
            KisiDetaySayfa(gelenKisi = nesne)
        }

    }
}