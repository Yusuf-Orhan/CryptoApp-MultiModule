package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.ListData
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoListMapper

class CryptoListMapper : CryptoListMapper<ListData, CryptoItemEntity> {
    override fun map(input: List<ListData>): List<CryptoItemEntity> {
        return input.map {
            CryptoItemEntity(
                it.id,
                it.name,
                it.volumeUsd
            )
        }
    }
}