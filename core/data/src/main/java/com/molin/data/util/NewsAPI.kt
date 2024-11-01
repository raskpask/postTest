package com.molin.data.util

import android.util.Log
import com.molin.data.model.News
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Inject

interface INewsAPI {
    suspend fun getNews(): Result<List<News>>
}

class NewsAPI
    @Inject
    constructor() : INewsAPI {
        override suspend fun getNews(): Result<List<News>> {
            try {
                val client =
                    HttpClient {
                        install(ContentNegotiation) {
                            json()
                        }
                    }
                val news: List<News> = client.get("https://jsonplaceholder.typicode.com/posts").body()

                return Result.success(news)
            } catch (e: Exception) {
                Log.e("Get news Error: ", e.message ?: "")
                return Result.failure(e)
            }
        }
    }
