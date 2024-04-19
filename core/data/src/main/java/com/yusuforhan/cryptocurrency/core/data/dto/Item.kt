package com.yusuforhan.cryptocurrency.core.data.dto

data class Item(
    val exchangeUrl: String,
    val id: String,
    val name: String,
    val percentTotalVolume: String,
    val rank: String,
    val socket: Boolean,
    val tradingPairs: String,
    val updated: Long,
    val volumeUsd: String
)