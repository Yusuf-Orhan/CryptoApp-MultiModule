package com.yusuforhan.cryptodetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


const val detailRoute = "detail_route"
const val detailArgumentKey = "crypto_name"
fun NavGraphBuilder.detailScreen(
    navigateToDetail: (String) -> Unit
) {
    composable(
        route = detailRoute,
        arguments = listOf(
            navArgument(detailArgumentKey, builder = { NavType.StringType })
        )
    ) {
        DetailRoute()
    }
}

fun NavHostController.navigateToDetail(
    name: String,
    navOptions: NavOptions? = null
) {
    navigate(
        route = detailRoute.plus("/$name"),
    )
}