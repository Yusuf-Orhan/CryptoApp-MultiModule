package com.yusuforhan.cryptocurrency.core.data.api

import com.yusuforhan.cryptocurrency.core.data.dto.CryptoList
import com.yusuforhan.cryptocurrency.core.data.dto.Item
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/IA32-CryptoComposeData/main/cryptolist.json")
    suspend fun getCryptoList() : CryptoList
    @GET("IA32-CryptoComposeData/main/crypto.json")
    suspend fun getCryptoItem(@Path("ID") id : String) : Item

}