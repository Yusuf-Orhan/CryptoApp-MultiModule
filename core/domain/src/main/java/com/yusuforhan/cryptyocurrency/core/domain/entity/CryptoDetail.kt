package com.yusuforhan.cryptyocurrency.core.domain.entity

data class CryptoDetail(
    val id : String,
    val name : String,
    val price_btc: String,
    val price_usd: String,
    val rank: Int,
    val symbol: String,
)
