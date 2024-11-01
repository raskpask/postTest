package com.molin.posttest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.molin.data.model.News
import com.molin.posttest.ui.theme.PostTestTheme

@Composable
fun MainScreen(state: MainUiState) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            "Nyheter",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = 12.dp),
        )
        AnimatedVisibility(enter = slideInVertically { it }, visible = state.news.isNotEmpty()) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(state.news) {
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(16.dp)) {
                            Text(
                                text = it.title,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(bottom = 12.dp),
                            )
                            Text(
                                text = it.body,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            Text(
                                text = it.id.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PostTestTheme {
        MainScreen(
            MainUiState(
                news =
                    listOf(
                        News(
                            userId = 1,
                            id = 1,
                            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                            body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
                        ),
                        News(
                            userId = 1,
                            id = 2,
                            title = "qui est esse",
                            body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla",
                        ),
                        News(
                            userId = 1,
                            id = 3,
                            title = "ea molestias quasi exercitationem repellat qui ipsa sit aut",
                            body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut",
                        ),
                    ),
            ),
        )
    }
}
