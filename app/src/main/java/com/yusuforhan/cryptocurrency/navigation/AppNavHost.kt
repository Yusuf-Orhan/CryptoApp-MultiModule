package com.yusuforhan.cryptocurrency.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.yusuforhan.cryptocurrency.features.cryptolist.homeRoute
import com.yusuforhan.cryptocurrency.features.cryptolist.homeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = homeRoute) {
        homeScreen(
            navigateToDetail = {navController.navigate("detail")}
        )
    }
}