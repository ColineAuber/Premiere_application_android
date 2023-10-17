package com.example.premiere_application

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController

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
                Text(
                    text = film.title,
                    style = MaterialTheme.typography.headlineLarge,
                )
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
