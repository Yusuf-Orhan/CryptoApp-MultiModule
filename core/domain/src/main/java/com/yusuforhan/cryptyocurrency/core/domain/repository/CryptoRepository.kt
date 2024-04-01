package com.yusuforhan.cryptyocurrency.core.domain.repository

import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItem

interface CryptoRepository {

    suspend fun getCryptoList() : List<CryptoItem>

    suspend fun getCryptoDetail() : CryptoDetail
}