package com.molin.data.di

import com.molin.data.repository.INewsRepository
import com.molin.data.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface IRepositoryModule {
    @Binds
    @Singleton
    fun bindNewsRepository(repository: NewsRepository): INewsRepository
}
