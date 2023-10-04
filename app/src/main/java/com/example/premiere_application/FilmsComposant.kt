package com.example.premiere_application

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.LaunchedEffect

@Composable
fun FilmComposant(
    classes: WindowSizeClass,
    navController: NavController,
    viewModel: MainViewModel
) {
    val classeHauteur = classes.heightSizeClass
    val films by viewModel.films.collectAsState()
    LaunchedEffect(true) {
        viewModel.films_tendance()
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 5.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(films) { film ->
                CardFilm(film, navController)
            }
        }
    }
}

@Composable
fun CardFilm(film: Film, navController: NavController) {
    MyCard(
        route = "filmDetail/" + film.id,
        chemin_img = film.poster_path,
        titre = film.title,
        date_sortie = film.release_date,
        navController = navController
    )
}















