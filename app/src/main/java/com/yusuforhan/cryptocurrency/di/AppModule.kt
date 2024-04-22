package com.yusuforhan.cryptocurrency.di

import com.yusuforhan.cryptocurrency.core.data.api.CryptoApi
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoDetailMapper
import com.yusuforhan.cryptocurrency.core.data.mapper.CryptoListMapperImpl
import com.yusuforhan.cryptocurrency.core.data.repository.CryptoRepositoryImpl
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
    fun provideCryptoListMapper(): CryptoListMapperImpl =
        CryptoListMapperImpl()

    @Provides
    @Singleton
    fun provideCryptDetailMapper(): CryptoDetailMapper = CryptoDetailMapper()

    @Provides
    @Singleton
    fun provideCryptoRepository(
        api: CryptoApi,
        cryptoListMapperImpl: CryptoListMapperImpl,
        cryptoDetailMapper: CryptoDetailMapper

    ): CryptoRepository = CryptoRepositoryImpl(
        api = api,
        cryptoListMapperImpl = cryptoListMapperImpl,
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
