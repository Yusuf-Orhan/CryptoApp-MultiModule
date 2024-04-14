package com.yusuforhan.cryptocurrency.core.data.repository

import com.yusuforhan.cryptocurrency.core.data.api.CryptoApi
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoDetailMapper
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoListMapper
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api : CryptoApi,
    private val cryptoListMapper : CryptoListMapper,
    private val cryptoDetailMapper : CryptoDetailMapper
) : CryptoRepository {
    override suspend fun getCryptoList(): List<CryptoItemEntity> {
        return cryptoListMapper.map(api.getCryptoList().data)
    }

    override suspend fun getCryptoDetail(id : Int): CryptoDetail {
        return cryptoDetailMapper.map(api.getCryptoItem(id))
    }
}