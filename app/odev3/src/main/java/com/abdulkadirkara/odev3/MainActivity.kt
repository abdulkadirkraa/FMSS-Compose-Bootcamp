package com.abdulkadirkara.odev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abdulkadirkara.odev3.ui.screens.BottomBarScreen
import com.abdulkadirkara.odev3.ui.theme.BootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BootcampTheme {
                BottomBarScreen()
            }
        }
    }
}

