package com.yusuforhan.cryptocurrency.core.data.repository

import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptocurrency.core.data.api.CryptoApi
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoDetailMapper
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoListMapperImpl
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi,
    private val cryptoListMapperImpl: CryptoListMapperImpl,
    private val cryptoDetailMapper: CryptoDetailMapper
) : CryptoRepository {
    override suspend fun getCryptoList(): Resource<List<CryptoItemEntity>> {
        return try {
            Resource.Loading
            Resource.Success(cryptoListMapperImpl.map(api.getCryptoList()))
        } catch (e: Exception) {
            Resource.Error(e.message.orEmpty())
        }
    }

    override suspend fun getCryptoDetail(id: String): Resource<CryptoDetail> {
        return try {
            Resource.Loading
            Resource.Success(cryptoDetailMapper.map(api.getCryptoItem(id)))
        } catch (e: Exception) {
            Resource.Error(e.message.orEmpty())
        }
    }
}