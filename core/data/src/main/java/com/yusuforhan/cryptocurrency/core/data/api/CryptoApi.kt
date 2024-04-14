package com.yusuforhan.cryptocurrency.core.data.api

import com.yusuforhan.cryptocurrency.core.data.dto.CryptoList
import com.yusuforhan.cryptocurrency.core.data.dto.CryptoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/api/tickers/")
    suspend fun getCryptoList() : CryptoList

    @GET("/api/ticker/{ID}")
    suspend fun getCryptoItem(@Path("ID")id : Int) : CryptoItem

}