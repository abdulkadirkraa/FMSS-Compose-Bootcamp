package com.abdulkadirkara.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulkadirkara.module2.ui.theme.AnaRenk
import com.abdulkadirkara.module2.ui.theme.BootcampTheme
import com.abdulkadirkara.module2.ui.theme.DarkAnaRenk
import com.abdulkadirkara.module2.ui.theme.DarkYaziRenk2
import com.abdulkadirkara.module2.ui.theme.YaziRenk1
import com.abdulkadirkara.module2.ui.theme.YaziRenk2
import com.abdulkadirkara.module2.ui.theme.pacifio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnaSayfa()
        }
    }
}

//İndirdiğin fontlarınismini küçük harf yap çünkü res'ler küçük olur

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(darkTheme: Boolean = isSystemInDarkTheme()) {
    val configuration = LocalConfiguration.current
    val ekranGenisligi = configuration.screenWidthDp
    val ekranYuksekligi = configuration.screenHeightDp

    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(R.string.app_name), fontFamily = pacifio) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (darkTheme) DarkAnaRenk else AnaRenk,
                titleContentColor = YaziRenk1
            )
        )
    }) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = stringResource(R.string.pizzaBaslik), color = if (darkTheme) DarkAnaRenk else AnaRenk, fontWeight = FontWeight.Bold, fontSize = (ekranGenisligi/10).sp)

            Image(painter = painterResource(id = R.drawable.yemek_resim3), contentDescription = "")

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                MyChip(stringResource(R.string.peynirYazi), darkTheme)
                MyChip(stringResource(R.string.sucukYazi), darkTheme)
                MyChip(stringResource(R.string.zeytinYazi), darkTheme)
                MyChip(stringResource(R.string.biberYazi), darkTheme)
            }

            Text(text = stringResource(R.string.teslimatSure), color = if (darkTheme) DarkYaziRenk2 else YaziRenk2, fontWeight = FontWeight.Bold, fontSize = 22.sp)

            Text(text = stringResource(R.string.teslimatBaslik), color = if (darkTheme) DarkAnaRenk else AnaRenk, fontWeight = FontWeight.Bold, fontSize = 22.sp)

            Text(text = stringResource(R.string.pizzaAciklama),
                color = if (darkTheme) DarkYaziRenk2 else YaziRenk2, fontSize = 22.sp, textAlign = TextAlign.Center)

            Row(
                //left = start = leading
                //right = end = trailing
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp), //all
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = stringResource(R.string.fiyatYazi), color = if (darkTheme) DarkAnaRenk else AnaRenk, fontWeight = FontWeight.Bold, fontSize = 44.sp)

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme) DarkAnaRenk else AnaRenk,
                        contentColor = YaziRenk1
                    )
                ) {
                    Text(text = stringResource(R.string.buttonYazi), fontSize = 18.sp)
                }

            }
        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    BootcampTheme {
        AnaSayfa()
    }
}

@Composable
fun MyChip(icerik: String, isDarkTheme: Boolean){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isDarkTheme) DarkAnaRenk else AnaRenk,
            contentColor = YaziRenk1
        )
    ) {
        Text(text = icerik, fontSize = 16.sp)
    }
}