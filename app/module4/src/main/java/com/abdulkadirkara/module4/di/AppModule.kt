package com.abdulkadirkara.module4.di

import com.abdulkadirkara.module4.data.datasource.KisilerDataSource
import com.abdulkadirkara.module4.data.repo.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providesKisilerRepository(kds : KisilerDataSource) : KisilerRepository {
        return KisilerRepository(kds)
    }
    @Provides
    fun providesKisilerDataSource() : KisilerDataSource {
        return KisilerDataSource()
    }
}