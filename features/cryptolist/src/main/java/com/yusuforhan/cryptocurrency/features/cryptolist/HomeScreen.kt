package com.yusuforhan.cryptocurrency.features.cryptolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity

@Composable
fun HomeRoute(
    viewModel : HomeViewModel = hiltViewModel(),
    navigateToDetail : (String) -> Unit
) {
    HomeScreen(
        viewModel = viewModel,
        onItemClick = navigateToDetail
    )
}
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onItemClick : (String) -> Unit
) {
    val state = viewModel.state.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading == true) {
            CircularProgressIndicator()
        } else if (state.error != null) {
            Text(text = state.error)
            Button(onClick = { viewModel.getCryptoList() }) {
                Text(text = "Try Again")
            }
        } else if (state.cryptoList != null) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoListItem(
    item: CryptoItemEntity
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta,
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            Text(text = item.currency!!, fontSize = 18.sp)
            Text(text = item.price!!)
        }
    }
}