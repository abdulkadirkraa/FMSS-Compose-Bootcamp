package com.abdulkadirkara.module4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.abdulkadirkara.module4.ui.screen.SayfaGecisleri
import com.abdulkadirkara.module4.ui.theme.BootcampTheme
import com.abdulkadirkara.module4.ui.viewmodel.AnaSayfaViewModel
import com.abdulkadirkara.module4.ui.viewmodel.KisiDetayViewModel
import com.abdulkadirkara.module4.ui.viewmodel.KisiKayitViewModel

class MainActivity : ComponentActivity() {
    private val anasayfaViewModel : AnaSayfaViewModel by viewModels()
    private val kisiKayitViewModel : KisiKayitViewModel by viewModels()
    private val kisiDetayViewModel : KisiDetayViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BootcampTheme {
                SayfaGecisleri(
                    anasayfaViewModel,
                    kisiKayitViewModel,
                    kisiDetayViewModel
                )
            }
        }
    }
}
