package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.Item
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper

class CryptoDetailMapper : CryptoBaseMapper<Item, CryptoDetail> {
    override fun map(input: Item): CryptoDetail {
        return CryptoDetail(
            input.id,
            input.name,
            input.logo_url
        )
    }
}