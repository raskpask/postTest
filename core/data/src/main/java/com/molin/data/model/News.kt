package com.molin.data.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)
