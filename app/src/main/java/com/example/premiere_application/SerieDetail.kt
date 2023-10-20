package com.example.premiere_application

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun SerieDetail(classes: WindowSizeClass, navController: NavController, viewModel : MainViewModel, id: String){
    val classeHauteur = classes.heightSizeClass
    val serie by viewModel.serie.collectAsState()
    LaunchedEffect(true) {
        viewModel.serie_detail(id)
    }

    when (classeHauteur) {
        WindowHeightSizeClass.Medium -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                    Row() {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = serie.name,
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier
                                    .padding(10.dp)
                            )
                            AsyncImage(
                                model = "https://image.tmdb.org/t/p/w500${serie.poster_path}",
                                contentDescription = serie.name
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
                                    text = serie.first_air_date,
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                            }
                            Row {
                                Text(
                                    text = "Genre(s) : ",
                                    style = MaterialTheme.typography.bodyMedium,
                                )
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
