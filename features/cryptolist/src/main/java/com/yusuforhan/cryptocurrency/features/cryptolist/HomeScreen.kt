package com.yusuforhan.cryptocurrency.features.cryptolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading == true) {
            CircularProgressIndicator()
        }else if (state.error != null) {
            Text(text = state.error)
        } else  if (state.cryptoList != null){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Blue)
            ) {
                items(state.cryptoList) {
                    CryptoListItem(item = it)
                }
            }
        }
    }
}

@Composable
fun CryptoListItem(
    item : CryptoItemEntity
) {
    Column {
        Text(text = item.currency!!)
        Text(text = item.price!!)
    }
}