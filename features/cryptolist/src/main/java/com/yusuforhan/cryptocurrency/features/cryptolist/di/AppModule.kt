package com.yusuforhan.cryptocurrency.features.cryptolist.di

import com.yusuforhan.cryptocurrency.core.data.api.CryptoApi
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoDetailMapper
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoListMapper
import com.yusuforhan.cryptocurrency.core.data.repository.CryptoRepositoryImpl
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideCryptoRepository(
        api: CryptoApi,
        cryptoListMapper: CryptoListMapper,
        cryptoDetailMapper: CryptoDetailMapper

    ): CryptoRepository = CryptoRepositoryImpl(
        api = api,
        cryptoListMapper = cryptoListMapper,
        cryptoDetailMapper = cryptoDetailMapper
    )
}