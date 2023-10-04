package com.example.premiere_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

                // mettre le NavHost dans le Scaffold
                NavHost(navController = navController, startDestination = "Profil") {
                    composable("Profil") { Ecran(windowSizeClass, navController) }
                    composable("FilmsComposant") {
                        FilmComposant(
                            classes = windowSizeClass,
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                    /*...*/
                }

            }

            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        items.forEach { screen ->
                            BottomNavigationItem(
                                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                                label = { Text(stringResource(screen.resourceId)) },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            )
            {
                    innerPadding ->
                NavHost(
                    navController,
                    startDestination = Screen.Profile.route,
                    Modifier.padding(innerPadding)
                ) {
                    composable(Screen.Profile.route) { Profile(navController) }
                    composable(Screen.FriendsList.route) { FriendsList(navController) }
                }
            }

        }

    }

}


