package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.CryptoItem
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoListMapper

class CryptoListMapperImpl : CryptoListMapper<CryptoItem, CryptoItemEntity> {
    override fun map(input: List<CryptoItem>): List<CryptoItemEntity> {
        return input.map {
            CryptoItemEntity(
                it.currency,
                it.price
            )
        }
    }
}