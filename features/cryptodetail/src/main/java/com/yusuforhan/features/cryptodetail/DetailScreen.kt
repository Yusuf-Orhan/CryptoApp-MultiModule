package com.yusuforhan.features.cryptodetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun DetailRoute(
    name : String
) {
    DetailScreen(name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    name : String
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Crypto Detail") }) }
    ) {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                fontSize = 48.sp
            )
            Image(imageVector = Icons.Default.Face, contentDescription = null)
        }
    }
}