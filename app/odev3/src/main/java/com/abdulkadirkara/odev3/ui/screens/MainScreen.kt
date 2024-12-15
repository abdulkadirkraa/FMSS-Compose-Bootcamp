package com.abdulkadirkara.odev3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.odev3.model.Categories
import com.abdulkadirkara.odev3.model.Products
import com.abdulkadirkara.odev3.R
import com.abdulkadirkara.odev3.ui.theme.BootcampTheme
import com.abdulkadirkara.odev3.ui.theme.cardOrange
import com.abdulkadirkara.odev3.ui.theme.darkCardOrange
import com.abdulkadirkara.odev3.ui.theme.grey
import com.abdulkadirkara.odev3.ui.theme.orange
import com.abdulkadirkara.odev3.ui.theme.ptserifBoldAndItalic
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MainScreen(darkTheme: Boolean = isSystemInDarkTheme()) {

    // ScrollState oluştur
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(scrollState) // Dikey kaydırmayı ekle
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        //En üstteki text'ler ve resim
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {
            Column {
                Text(
                    text = stringResource(R.string.hi_user),
                    color = orange,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = ptserifBoldAndItalic)
                Text(
                    text = stringResource(R.string.order_and_eat),
                    color = if (darkTheme) Color.White else Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)
            }
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
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
                Text(
                    text = stringResource(R.string.search_hint),
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
                containerColor = if (darkTheme) darkCardOrange else cardOrange
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
                        text = stringResource(R.string.free_delivery),
                        color = if (darkTheme) Color.Black else Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.delivery_dates),
                        color = if (darkTheme) Color.Black else Color.White,
                        fontSize = 20.sp
                    )

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkTheme) cardOrange else orange,
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.order_now),
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        //Kategoriler lazyrow'u
        Text(
            text = stringResource(R.string.categories),
            color = if (darkTheme) Color.White else Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = ptserifBoldAndItalic,
            modifier = Modifier.padding(8.dp)
                .align(Alignment.Start))

        val categories = listOf<Categories>(
            Categories(R.drawable.cat_1, "Pizza"),
            Categories(R.drawable.cat_2, "Burger"),
            Categories(R.drawable.cat_3,"Hotdog"),
            Categories(R.drawable.cat_4,"Drink"),
            Categories(R.drawable.cat_5,"Dessert"),
            Categories(R.drawable.cat_1,"Sushi"),
            Categories(R.drawable.cat_2,"Salad"),
            Categories(R.drawable.cat_3,"Icecream"),
            Categories(R.drawable.cat_4,"Tea"),
            Categories(R.drawable.cat_5,"Coffee")
        )
        LazyRow {
            items(categories) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(4.dp), // Gölge efekti isteğe bağlı
                    colors = CardDefaults.cardColors(
                        containerColor = if (darkTheme) darkCardOrange else grey
                    )

                ) {
                    // Box ile tam ortalama sağlanır
                    Box(
                        modifier = Modifier.fillMaxSize(), // Card boyutunun tamamını kapla
                        contentAlignment = Alignment.Center // Hem yatay hem dikey ortala
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center // Dikey ortalama
                        ) {
                            Image(
                                painter = painterResource(it.img),
                                contentDescription = "",
                                modifier = Modifier.size(48.dp) // Görsel boyutu
                            )
                            Text(
                                text = it.name,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        //Popular lazyrow'u
        Row(modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(R.string.popular),
                color = if (darkTheme) Color.White else Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = ptserifBoldAndItalic,
                modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(R.string.see_all),
                color = orange,
                modifier = Modifier.padding(8.dp))
        }

        val products = listOf<Products>(
            Products("Pepperoni", R.drawable.pop_1, "9.76"),
            Products("Cheese Burger", R.drawable.pop_2, "8.79"),
            Products("Vegetable Pizza", R.drawable.pop_3, "7.99"),
            Products("Chicken Supreme", R.drawable.pop_1, "10.50"),
            Products("Classic Burger", R.drawable.pop_2, "8.25"),
            Products("Margarita Pizza", R.drawable.pop_3, "7.50"),
            Products("Spicy Pepperoni", R.drawable.pop_1, "10.99"),
            Products("BBQ Burger", R.drawable.pop_2, "9.49"),
            Products("Garden Fresh", R.drawable.pop_3, "8.20"),
            Products("Meat Lovers", R.drawable.pop_1, "12.99"),
        )
        LazyRow {
            items(products){
                OutlinedCard(
                    modifier = Modifier.wrapContentWidth().padding(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (darkTheme) darkCardOrange else grey
                    )) {
                    Column(modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = it.name,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(
                            Alignment.CenterHorizontally))
                        Image(painter = painterResource(it.image), contentDescription = "",
                            modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally))
                        Row(horizontalArrangement = Arrangement.Center) {
                            Text(text = stringResource(R.string.currency_symbol), color = orange, fontSize = 12.sp)
                            Text(
                                text = it.price,
                                color = Color.Black,
                                fontSize = 20.sp)
                        }
                        Button(onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = orange,
                                contentColor = Color.White
                            ),
                            modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text= stringResource(R.string.add_button), fontWeight = FontWeight.Bold)
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