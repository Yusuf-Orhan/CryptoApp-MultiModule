package com.yusuforhan.cryptyocurrency.core.domain.mapper

interface CryptoBaseMapper<I,T> {
    fun map(input : I) : T
}