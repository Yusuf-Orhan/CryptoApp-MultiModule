package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.Item
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoListMapper

class CryptoListMapperImpl : CryptoListMapper<Item, CryptoItemEntity> {
    override fun map(input: List<Item>): List<CryptoItemEntity> {
        return input.map {
            CryptoItemEntity(
                it.id,
                it.name,
                it.volumeUsd
            )
        }
    }
}