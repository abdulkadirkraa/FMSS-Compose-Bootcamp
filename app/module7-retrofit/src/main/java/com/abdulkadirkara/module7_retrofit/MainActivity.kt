package com.abdulkadirkara.module7_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdulkadirkara.module7_retrofit.ui.screen.SayfaGecisleri
import com.abdulkadirkara.module7_retrofit.ui.theme.BootcampTheme
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.AnasayfaViewModel
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.KisiDetayViewModel
import com.abdulkadirkara.module7_retrofit.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val anasayfaViewModel: AnasayfaViewModel by viewModels()
    val kisiKayitViewModel: KisiKayitViewModel by viewModels()
    val kisiDetayViewModel: KisiDetayViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BootcampTheme {
                SayfaGecisleri(
                    anasayfaViewModel = anasayfaViewModel,
                    kisiDetayViewModel = kisiDetayViewModel,
                    kisiKayitViewModel = kisiKayitViewModel)
            }
        }
    }
}