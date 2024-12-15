package com.abdulkadirkara.odev4

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdulkadirkara.odev4.ui.screens.ScreenA
import com.abdulkadirkara.odev4.ui.screens.ScreenB
import com.abdulkadirkara.odev4.ui.screens.ScreenMain
import com.abdulkadirkara.odev4.ui.screens.ScreenX
import com.abdulkadirkara.odev4.ui.screens.ScreenY

@Composable
fun NavigatingBetweenScreens(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController= navController, startDestination = "screenMain") {
        composable("screenMain"){
            ScreenMain(innerPadding, navController)
        }
        composable("screenA"){
            ScreenA(innerPadding, navController)
        }
        composable("screenB"){
            ScreenB(innerPadding, navController)
        }
        composable("screenX"){
            ScreenX(innerPadding, navController)
        }
        composable("screenY"){
            ScreenY(innerPadding, navController)
        }
    }
}