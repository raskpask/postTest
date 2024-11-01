package com.molin.posttest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.molin.data.model.News
import com.molin.posttest.ui.theme.PostTestTheme

data class MainUiState(
    val news: List<News> = listOf()
)
