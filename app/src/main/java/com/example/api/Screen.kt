package com.example.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ShowListScreen(viewModel: ShowViewModel = ShowViewModel()) {
    val shows = viewModel.shows.value

    LaunchedEffect(Unit) {
        viewModel.fetchShows()
    }

            LazyColumn {
                items(shows) { show ->
                    Column(modifier = Modifier.padding(8.dp)) {
                        // Poster image
                        AsyncImage(
                            model = show.image?.medium,
                            contentDescription = show.name
                        )

                        // Text info
                        Text(text = show.name ?: "Unknown", style = MaterialTheme.typography.titleMedium)
                        Text(text = "Language: ${show.language ?: "N/A"}")
                        Text(text = "Genres: ${show.genres?.joinToString() ?: "None"}")
                        Text(text = "Status: ${show.status ?: "N/A"}")
                    }
                }
            }

}

