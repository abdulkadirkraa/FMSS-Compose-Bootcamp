package com.abdulkadirkara.module3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abdulkadirkara.module3.ui.screens.SayfaGecisleri
import com.abdulkadirkara.module3.ui.theme.BootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BootcampTheme {
                SayfaGecisleri("anasayfa")
            }
        }
    }
}

