package com.yusuforhan.cryptocurrency.core.data.api

import com.yusuforhan.cryptocurrency.core.data.dto.ItemData
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/v2/exchanges")
    suspend fun getCryptoList() : CryptoList

    @GET("/v2/exchanges/{ID}")
    suspend fun getCryptoItem(@Path("ID") id : String) : ItemData

}