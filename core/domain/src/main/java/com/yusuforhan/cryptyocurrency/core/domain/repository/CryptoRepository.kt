package com.yusuforhan.cryptyocurrency.core.domain.repository

import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity

interface CryptoRepository {

    suspend fun getCryptoList() : Resource<List<CryptoItemEntity>>

    suspend fun getCryptoDetail(id : Int) : Resource<CryptoDetail>
}