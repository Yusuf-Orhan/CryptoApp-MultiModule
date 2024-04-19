package com.yusuforhan.cryptocurrency.core.data.di

import com.yusuforhan.cryptocurrency.core.data.dto.Item
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoDetailMapper
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoListMapper
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideCryptoListMapper(): com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoListMapper<Item, CryptoItemEntity> =
        CryptoListMapper()

    @Provides
    @Singleton
    fun provideCryptDetailMapper(): CryptoBaseMapper<Item, CryptoDetail> = CryptoDetailMapper()
}