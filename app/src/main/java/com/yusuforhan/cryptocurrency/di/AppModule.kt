package com.yusuforhan.cryptocurrency.di

import com.yusuforhan.cryptocurrency.core.data.api.CryptoApi
import com.yusuforhan.cryptocurrency.core.data.dto.Item
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoDetailMapper
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoListMapper
import com.yusuforhan.cryptocurrency.core.data.repository.CryptoRepositoryImpl
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoBaseMapper
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCryptoListMapper(): com.yusuforhan.cryptyocurrency.core.domain.mapper.CryptoListMapper<Item, CryptoItemEntity> =
        CryptoListMapper()

    @Provides
    @Singleton
    fun provideCryptDetailMapper(): CryptoBaseMapper<Item, CryptoDetail> = CryptoDetailMapper()

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

    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi = Retrofit.Builder()
        .baseUrl("https://api.coincap.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoApi::class.java)
}
