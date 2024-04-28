package com.yusuforhan.cryptocurrency.features.cryptolist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val homeRoute = "home_route"
fun NavGraphBuilder.homeScreen(
    navigateToDetail : (String) -> Unit
) {
    composable(
        route = homeRoute
    ){
        HomeRoute(navigateToDetail = navigateToDetail)
    }
}

fun NavHostController.navigateToHome(
    navOptions: NavOptions? = null
) {
    navigate(
       route = homeRoute
    )
}