package com.yusuforhan.cryptyocurrency.core.domain.repository

import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity

interface CryptoRepository {

    suspend fun getCryptoList() : List<CryptoItemEntity>

    suspend fun getCryptoDetail(id : Int) : CryptoDetail
}