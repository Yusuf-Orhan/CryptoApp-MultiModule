package com.yusuforhan.cryptocurrency.core.data.api

import com.yusuforhan.cryptocurrency.core.data.dto.CryptoItem
import com.yusuforhan.cryptocurrency.core.data.dto.Item
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("cryptolist.json")
    suspend fun getCryptoList() : List<CryptoItem>
    @GET("crypto.json")
    suspend fun getCryptoItem(@Path("ID") id : String) : Item

}