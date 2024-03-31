package com.yusuforhan.cryptocurrency.core.data.dto

data class CryptoItem(
    val csupply: String,
    val id: String,
    val market_cap_usd: String,
    val msupply: String,
    val name: String,
    val nameid: String,
    val percent_change_1h: String,
    val percent_change_24h: String,
    val percent_change_7d: String,
    val price_btc: String,
    val price_usd: String,
    val rank: Int,
    val symbol: String,
    val tsupply: String,
    val volume24: Double,
    val volume24a: Double
)