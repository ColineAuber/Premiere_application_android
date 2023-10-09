package com.example.premiere_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.premiere_application.ui.theme.Premiere_applicationTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()
        // recupérer viewModel : voir vidéo sur Retrofit (12min)


        setContent {
            Premiere_applicationTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                //Ecran(windowSizeClass)
                // A surface container using the 'background' color from the theme

                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            BottomNavigationItem(
                                icon = {
                                    Image(
                                        painterResource(id = R.drawable.clap),
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
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "Profil", modifier=Modifier.padding(innerPadding)) {
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


