package com.yusuforhan.cryptocurrency.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.yusuforhan.cryptocurrency.features.cryptolist.homeRoute
import com.yusuforhan.cryptocurrency.features.cryptolist.homeScreen
import com.yusuforhan.cryptocurrency.features.cryptolist.navigateToHome
import com.yusuforhan.features.cryptodetail.detailScreen
import com.yusuforhan.features.cryptodetail.navigateToDetail


@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = homeRoute) {
        homeScreen(
            navigateToDetail = { navController.navigateToDetail(it) }
        )
        detailScreen(
            navigateToHome = { navController.navigateToHome() }
        )

    }
}