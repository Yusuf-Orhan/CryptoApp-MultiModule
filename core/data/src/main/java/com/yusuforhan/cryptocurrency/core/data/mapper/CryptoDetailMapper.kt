package com.yusuforhan.cryptocurrency.core.data.mapper

import com.yusuforhan.cryptocurrency.core.data.dto.DetailItem
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper

class CryptoDetailMapper : CryptoBaseMapper<DetailItem, CryptoDetail> {
    override fun map(input: DetailItem): CryptoDetail {
        return CryptoDetail(
            input.id,
            input.name,
            input.logo_url
        )
    }
}