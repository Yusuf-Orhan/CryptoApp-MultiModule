package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.ItemData
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper

class CryptoDetailMapper : CryptoBaseMapper<ItemData,CryptoDetail> {
    override fun map(input: ItemData): CryptoDetail {
        return CryptoDetail(
            input.id,
            input.name,
            input.rank,
            input.volumeUsd
        )
    }
}