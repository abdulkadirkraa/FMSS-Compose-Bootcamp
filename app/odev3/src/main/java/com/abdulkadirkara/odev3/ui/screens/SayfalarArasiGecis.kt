package com.abdulkadirkara.odev3.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfalarArasiGecis(secilenSayfa:String){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = secilenSayfa){
        composable("mainscreen"){ MainScreen() }
        composable("notifscreen"){ NotifScreen() }
        composable("shoppingcardscreen"){ ShoppingCardScreen() }
        composable("profileScreen"){ ProfileScreen() }
        composable("settingscreen"){ SettingsScreen() }


    }
}