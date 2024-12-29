package com.abdulkadirkara.module7_retrofit.di

import com.abdulkadirkara.module7_retrofit.data.datasource.KisilerDataSource
import com.abdulkadirkara.module7_retrofit.data.repo.KisilerRepository
import com.abdulkadirkara.module7_retrofit.retrofit.ApiUtils
import com.abdulkadirkara.module7_retrofit.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerRepository(kisilerDataSource: KisilerDataSource) : KisilerRepository {
        return KisilerRepository(kisilerDataSource)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(kisilerDao: KisilerDao) : KisilerDataSource {
        return KisilerDataSource(kisilerDao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao() : KisilerDao {
        return ApiUtils.getKisilerDao()
    }
}