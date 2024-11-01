package com.molin.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val newsList: List<News>,
)
