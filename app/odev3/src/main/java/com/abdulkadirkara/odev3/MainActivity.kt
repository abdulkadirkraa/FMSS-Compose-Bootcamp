package com.abdulkadirkara.odev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.Categories
import com.abdulkadirkara.Products
import com.abdulkadirkara.odev3.ui.theme.BootcampTheme
import com.abdulkadirkara.odev3.ui.theme.btnOrange
import com.abdulkadirkara.odev3.ui.theme.orange
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BootcampTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

        //En üstteki text'ler ve resim
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,) {
            Column {
                Text(text = "Hi, Kadir", color = orange, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Order & Eat", color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier.weight(1f)
                    .align(Alignment.CenterVertically)
                    .size(48.dp),
                alignment = Alignment.CenterEnd)
        }

        //SearchBar
        val searchItem = remember { mutableStateOf("") }

        OutlinedTextField(
            value = searchItem.value,
            onValueChange = { searchItem.value = it },
            label = {
                Text(text = "Find your favorite foods",
                fontStyle = FontStyle.Italic) },
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "")
            }
        )

        //Card yapısı
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFA500) // Orange
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.Bottom // Tüm içerikleri altta hizala
            ) {
                // Lottie Animasyonu
                val lottie by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie))
                val progress by animateLottieCompositionAsState(
                    composition = lottie,
                    isPlaying = true,
                    iterations = LottieConstants.IterateForever
                )

                LottieAnimation(
                    composition = lottie,
                    progress = { progress },
                    modifier = Modifier
                        .size(150.dp) // Animasyon boyutunu ayarla
                        .weight(1f) // Sol tarafın uygun boyutta kaplamasını sağla
                )

                // Sağdaki Metin ve Buton
                Column(
                    modifier = Modifier
                        .weight(1f) // Sağ tarafın uygun boyutta kaplamasını sağla
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Bottom, // İçerikleri alta hizala
                    horizontalAlignment = Alignment.Start // Soldan hizala
                ) {
                    Text(
                        text = "Free delivery",
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "May 2 - June 10",
                        fontSize = 20.sp
                    )

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF8C00) // Daha koyu turuncu
                        )
                    ) {
                        Text(
                            text = "Order Now",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        //Kategoriler lazyrow'u
        Text(text = "Categories", color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
                .align(Alignment.Start))

        val categories = listOf<Categories>(
            Categories(R.drawable.cat_1, "Pizza"),
            Categories(R.drawable.cat_2, "Burger"),
            Categories(R.drawable.cat_3,"Hotdog"),
            Categories(R.drawable.cat_4,"Drink"),
            Categories(R.drawable.cat_5,"Dessert")
        )
        LazyRow {
            items(categories){
                Card(modifier = Modifier.size(80.dp).padding(4.dp)
                    .align(Alignment.CenterHorizontally)) {
                    Column(modifier = Modifier.padding(4.dp).align(Alignment.CenterHorizontally),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(it.img)
                            , contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterHorizontally))
                        Text(text = it.name, modifier = Modifier.align(Alignment.CenterHorizontally))
                    }

                }
            }
        }

        //Popular lazyrow'u
        Row(modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Popular", color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp))
            Text(text = "See all", color = orange,modifier = Modifier.padding(8.dp))
        }

        val products = listOf<Products>(
            Products("Pepperoni",R.drawable.pop_1,"9.76"),
            Products("Cheese Burger",R.drawable.pop_2, "8.79"),
            Products("Vegatable",R.drawable.pop_3,"7.99")
        )
        LazyRow {
            items(products){
                OutlinedCard(modifier = Modifier.wrapContentWidth().padding(4.dp)) {
                    Column(modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = it.name, textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterHorizontally))
                        Image(painter = painterResource(it.image), contentDescription = "",
                        modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally))
                        Row(horizontalArrangement = Arrangement.Center) {
                            Text(text = "$ ", color = orange, fontSize = 12.sp)
                            Text(text = it.price, color = Color.Black, fontSize = 20.sp)
                        }
                        Button(onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = orange,
                                contentColor = Color.White
                            ),
                            modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text="+ Add", fontWeight = FontWeight.Bold)
                        }
                    }

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BootcampTheme {
        MainScreen()
    }
}
