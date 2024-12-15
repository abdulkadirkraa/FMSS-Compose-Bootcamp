package com.abdulkadirkara.odev4.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenY(innerPadding: PaddingValues, navController: NavController){

    BackHandler (enabled = true){
        navController.navigate("screenMain"){
            navController.popBackStack()
        }
    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen Y", modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFAD8C2F),
                    titleContentColor = Color.White
                )
            )
        }
    ){ innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center,
            ) {
            Text(text = "This screen is the last page, if you go back you will return to the Main Screen",
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
                    .padding(innerPadding),
                fontSize = 24.sp,
                textAlign = TextAlign.Center)
        }
    }
}