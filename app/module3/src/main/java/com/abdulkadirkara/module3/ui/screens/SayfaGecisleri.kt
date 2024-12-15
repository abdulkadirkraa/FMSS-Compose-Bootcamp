package com.abdulkadirkara.module3.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun SayfaGecisleri(secilenSayfa: String){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = secilenSayfa){
        composable("anasayfa"){//bunlar id'ler ve sınıflarımızı temsil ederler
            AnaSayfa(navController = navController)//named argument vermek iyi olur
        }
        composable("detaySayfa/{sayac}", //burdaki 2sayac id'si de aynı olmalı
            arguments = listOf(
                navArgument(name = "sayac"){type = NavType.StringType}
            )){
            val gelenSayac = it.arguments?.getString("sayac") // bu nullable
            DetaySayfa(sayac = gelenSayac!!)
        }
        composable("ayarlarSayfa"){
            AyarlarSayfa()
        }
    }
}