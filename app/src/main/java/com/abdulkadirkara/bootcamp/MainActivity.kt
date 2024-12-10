package com.abdulkadirkara.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdulkadirkara.bootcamp.ui.theme.BootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {// İçeriği temsil eder
            BootcampTheme {
                //Bu scaffold uyg ilk sayfamız
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                Anasayfa()
            }
        }
    }
}

//Compose fonksiyonları büyük harfle başlar
@Composable
fun Anasayfa() {
    //Text(text = "Merhaba Anasayfa",Modifier.background(Color.Red))
//    Column(horizontalAlignment = Alignment.End,
//        verticalArrangement = Arrangement.SpaceEvenly,
//        modifier = Modifier.fillMaxHeight()) {
//        Box(modifier = Modifier.size(100.dp).background(Color.Red))
//        Box(modifier = Modifier.size(80.dp).background(Color.Green))
//        Box(modifier = Modifier.size(50.dp).background(Color.Blue))
//
//    }
    Row (horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.size(100.dp).background(Color.Red))
        Box(modifier = Modifier.size(80.dp).background(Color.Green))
        Box(modifier = Modifier.size(50.dp).background(Color.Blue))
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)//Önizleme sayfası
@Composable
fun GreetingPreview() {
    BootcampTheme {
        //Greeting("Android")
        Anasayfa()
    }
}