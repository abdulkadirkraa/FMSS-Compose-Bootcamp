package com.abdulkadirkara.odev4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.abdulkadirkara.odev4.ui.theme.BootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BootcampTheme {
                Scaffold() { innerPadding ->
                    NavigatingBetweenScreens(innerPadding)
                }
            }
        }
    }
}
