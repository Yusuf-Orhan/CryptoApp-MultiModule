package com.yusuforhan.cryptocurrency.core.data.dto


class CryptoDetail() : ArrayList<DetailItem>()
data class DetailItem(
    val id : String,
    val logo_url : String,
    val name : String
)