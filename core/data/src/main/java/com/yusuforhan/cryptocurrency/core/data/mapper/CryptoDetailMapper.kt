package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.CryptoItem
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper

class CryptoDetailMapper : CryptoBaseMapper<CryptoItem,CryptoDetail> {
    override fun map(input: CryptoItem): CryptoDetail {
        return CryptoDetail(
            input.id,
            input.name,
            input.price_usd,
            input.price_btc,
            input.rank,
            input.symbol
        )
    }
}