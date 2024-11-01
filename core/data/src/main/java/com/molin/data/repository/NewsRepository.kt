package com.molin.data.repository

import com.molin.data.model.News
import com.molin.data.util.INewsAPI
import javax.inject.Inject

interface INewsRepository {
    suspend fun getNews(): Result<List<News>>
}

class NewsRepository
    @Inject
    constructor(
        private val newsAPI: INewsAPI,
    ) : INewsRepository {
        override suspend fun getNews(): Result<List<News>> = newsAPI.getNews()
    }
