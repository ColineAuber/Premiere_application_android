package com.example.premiere_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.premiere_application.ui.theme.Premiere_applicationTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()
        // recupérer viewModel : voir vidéo sur Retrofit (12min)


        setContent {
            Premiere_applicationTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                //Ecran(windowSizeClass)
                // A surface container using the 'background' color from the theme

                var text by remember { mutableStateOf("") }
                var active by remember { mutableStateOf(false) }
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                Scaffold(
                        topBar = {
                            if(currentDestination?.route == "FilmsComposant") {
                                SearchBar(
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "icone loupe"
                                        )
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    query = text,
                                    onQueryChange = { text = it },
                                    onSearch = {
                                        viewModel.films_recherche(it)
                                     },
                                    active = active,
                                    onActiveChange = { active = it },
                                    placeholder = {
                                        Text(text = "Search")
                                    }
                                ) {
                                    val films by viewModel.filmsR.collectAsState()

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
                            }else if(currentDestination?.route == "ActeursComposant") {
                                SearchBar(
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "icone loupe"
                                        )
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    query = text,
                                    onQueryChange = { text = it },
                                    onSearch = {
                                        viewModel.acteurs_recherche(it)
                                    },
                                    active = active,
                                    onActiveChange = { active = it },
                                    placeholder = {
                                        Text(text = "Search")
                                    }
                                ) {
                                    val acteurs by viewModel.acteursR.collectAsState()

                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        LazyVerticalGrid(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(bottom = 5.dp),
                                            columns = GridCells.Fixed(2)
                                        ) {
                                            items(acteurs) { acteur ->
                                                CardActeur(acteur, navController)
                                            }
                                        }
                                    }
                                }
                            }else if(currentDestination?.route == "SeriesComposant") {
                                SearchBar(
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "icone loupe"
                                        )
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    query = text,
                                    onQueryChange = { text = it },
                                    onSearch = {
                                        viewModel.series_recherche(it)
                                    },
                                    active = active,
                                    onActiveChange = { active = it },
                                    placeholder = {
                                        Text(text = "Search")
                                    }
                                ) {
                                    val series by viewModel.seriesR.collectAsState()

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
                            }
                        },
                        bottomBar = {
                            if(currentDestination?.route != "Profil") {
                            BottomNavigation {

                                BottomNavigationItem(
                                    icon = {
                                        Image(
                                            painterResource(id = R.drawable.clap_bis),
                                            contentDescription = "logo films",
                                        )
                                    },
                                    label = { Text("Films") },
                                    selected = false,
                                    onClick = {
                                        navController.navigate("FilmsComposant")
                                    })
                                BottomNavigationItem(
                                    icon = {
                                        Image(
                                            painterResource(id = R.drawable.acteur),
                                            contentDescription = "logo acteurs",
                                        )
                                    },
                                    label = { Text("Acteurs") },
                                    selected = false,
                                    onClick = {
                                        navController.navigate("ActeursComposant")
                                    })
                                BottomNavigationItem(
                                    icon = {
                                        Image(
                                            painterResource(id = R.drawable.video),
                                            contentDescription = "logo séries",
                                        )
                                    },
                                    label = { Text("Séries") },
                                    selected = false,
                                    onClick = {
                                        navController.navigate("SeriesComposant")
                                    })

                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Profil",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("Profil") { Ecran(windowSizeClass, navController) }
                        composable("FilmsComposant") {
                            FilmComposant(
                                classes = windowSizeClass,
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        composable("SeriesComposant") {
                            SeriesComposant(
                                classes = windowSizeClass,
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        composable("ActeursComposant") {
                            ActeurComposant(
                                classes = windowSizeClass,
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        /*...*/
                    }
                }

                // mettre le NavHost dans le Scaffold


            }


        }

    }

}


