package com.example.premiere_application

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
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
fun SeriesComposant(
    classes: WindowSizeClass,
    navController: NavController,
    viewModel: MainViewModel
) {
    val classeHauteur = classes.heightSizeClass
    val series by viewModel.series.collectAsState()
    LaunchedEffect(true) {
        viewModel.series_tendance()
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 5.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(series) { serie ->
                CardSerie(serie, navController)
            }
        }
    }
}

@Composable
fun CardSerie(serie: Serie, navController: NavController) {
    MyCard(
        route = "seriesDetail/" + serie.id,
        chemin_img = serie.poster_path,
        titre = serie.name,
        date = serie.first_air_date,
        navController = navController
    )
}