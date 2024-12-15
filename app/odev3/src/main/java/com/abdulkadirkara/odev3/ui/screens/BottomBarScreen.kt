package com.abdulkadirkara.odev3.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdulkadirkara.odev3.R
import com.abdulkadirkara.odev3.ui.theme.cardOrange
import com.abdulkadirkara.odev3.ui.theme.darkGrey
import com.abdulkadirkara.odev3.ui.theme.darkOrange
import com.abdulkadirkara.odev3.ui.theme.grey
import com.abdulkadirkara.odev3.ui.theme.orange

@Composable
fun BottomBarScreen(darkTheme: Boolean = isSystemInDarkTheme()){
    val secilenItem = remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = if (darkTheme) darkGrey else cardOrange,
                content = {
                NavigationBarItem(
                    selected = secilenItem.value == 0,
                    onClick = { secilenItem.value = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = "") },
                    label = { Text(text = stringResource(R.string.home)) },
                    alwaysShowLabel = false
                )
                    NavigationBarItem(
                        selected = secilenItem.value == 1,
                        onClick = { secilenItem.value = 1 },
                        alwaysShowLabel = false,
                        icon = {
                            androidx.compose.material3.BadgedBox(
                                badge = {
                                    androidx.compose.material3.Badge(
                                        content = { Text("2") },
                                        containerColor = orange
                                    )
                                }
                            ) {
                                Icon(Icons.Default.Person, contentDescription = "")
                            }
                        },
                        label = { Text(text = stringResource(R.string.profile)) }
                    )
                NavigationBarItem(
                    selected = secilenItem.value == 2,
                    onClick = { secilenItem.value = 2 },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "") },
                    label = { Text(text = stringResource(R.string.shopping_card)) },
                    alwaysShowLabel = false
                )
                NavigationBarItem(
                    selected = secilenItem.value == 3,
                    onClick = { secilenItem.value = 3 },
                    icon = { Icon(Icons.Default.Notifications, contentDescription = "") },
                    label = { Text(text = stringResource(R.string.notification)) },
                    alwaysShowLabel = false
                )
                    NavigationBarItem(
                        selected = secilenItem.value == 4,
                        onClick = { secilenItem.value = 4 },
                        icon = {
                            androidx.compose.material3.BadgedBox(
                                badge = {
                                    androidx.compose.material3.Badge(
                                        containerColor = orange
                                    )
                                }
                            ) {
                                Icon(Icons.Default.Settings, contentDescription = "")
                            }
                        },
                        label = { Text(text = stringResource(R.string.settings)) },
                        alwaysShowLabel = false
                    )

            })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(secilenItem.value){
                0 -> SayfalarArasiGecis("mainscreen")
                1 -> SayfalarArasiGecis("profileScreen")
                2 -> SayfalarArasiGecis("shoppingcardscreen")
                3 -> SayfalarArasiGecis("notifscreen")
                4 -> SayfalarArasiGecis("settingscreen")

            }
        }

    }
}