package com.example.premiere_application

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun FilmDetail(classes: WindowSizeClass, navController: NavController, viewModel : MainViewModel, id: String){
    val classeHauteur = classes.heightSizeClass
    val film by viewModel.film.collectAsState()
    LaunchedEffect(true) {
        viewModel.film_detail(id)
    }

    when (classeHauteur) {
        WindowHeightSizeClass.Medium -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column() {
                    Row() {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = film.title,
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier
                                    .padding(10.dp)
                            )

                            AsyncImage(
                                model = "https://image.tmdb.org/t/p/w500${film.poster_path}",
                                contentDescription = film.title
                            )
                        }
                    }
                    Row() {
                        Column() {
                            Text(
                                text = "Details",
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = Modifier
                                    .padding(10.dp)
                            )
                            Row {
                                Text(
                                    text = "Date : ",
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                                Text(
                                    text = film.release_date,
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                            }
                            Row {
                                Text(
                                    text = "Genre(s) : ",
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                                film.genre_ids.forEach {
                                    Text(
                                        text = it.toString(),
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


        WindowHeightSizeClass.Compact -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

            }
        }
    }
}
