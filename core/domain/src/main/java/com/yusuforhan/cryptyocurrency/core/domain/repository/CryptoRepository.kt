package com.yusuforhan.cryptyocurrency.core.domain.repository

import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    fun getCryptoList() : Flow<Resource<List<CryptoItemEntity>>>

    suspend fun getCryptoDetail(id : String) : Resource<CryptoDetail>
}