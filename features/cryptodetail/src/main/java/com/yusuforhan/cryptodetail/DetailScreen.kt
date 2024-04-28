package com.yusuforhan.cryptodetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailRoute() {
    DetailScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Crypto Detail") }) }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Text("Detail Screen")
        }
    }
}