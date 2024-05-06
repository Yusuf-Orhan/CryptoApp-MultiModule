package com.yusuforhan.cryptocurrency.core.data.api

import com.yusuforhan.cryptocurrency.core.data.dto.CryptoDetail
import com.yusuforhan.cryptocurrency.core.data.dto.CryptoItem
import retrofit2.http.GET

interface CryptoApi {

    @GET("cryptolist.json")
    suspend fun getCryptoList() : List<CryptoItem>
    @GET("crypto.json")
    suspend fun getCryptoItem() : CryptoDetail

}