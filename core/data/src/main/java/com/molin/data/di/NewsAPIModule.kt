package com.molin.data.di

import com.molin.data.util.INewsAPI
import com.molin.data.util.NewsAPI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface INewsAPIModule {
    @Binds
    @Singleton
    fun bindNewsAPI(newsAPI: NewsAPI): INewsAPI
}
