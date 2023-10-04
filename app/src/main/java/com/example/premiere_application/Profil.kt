package com.example.premiere_application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
    fun Ecran(classes: WindowSizeClass, navController: NavController) {
        val classeHauteur = classes.heightSizeClass
        when (classeHauteur) {
            WindowHeightSizeClass.Medium -> {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painterResource(id = R.drawable.selfie),
                                contentDescription = "Photo Coline",
                                modifier = Modifier
                                    .size(300.dp)
                                    .padding(20.dp)
                                    .clip(CircleShape)
                            )

                            Text(
                                text = "Coline Auber",
                                style = MaterialTheme.typography.headlineLarge,
                            )

                            Text(
                                text = "Etudiante à l'école d'ingénieur ISIS - INU Champollion",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(10.dp)
                            )
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                Modifier
                                    .padding(top = 50.dp)
                                    .width(400.dp)
                            ) {
                                item {
                                    Box() {
                                        Image(
                                            painterResource(id = R.drawable.email),
                                            contentDescription = "Icone mail",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .padding(bottom = 5.dp, end = 5.dp)
                                                .align(Alignment.BottomEnd)
                                        )
                                    }
                                }
                                item {
                                    Text(
                                        text = "colineauber@yahoo.fr",
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                                item {
                                    Box() {
                                        Image(
                                            painterResource(id = R.drawable.linkedin),
                                            contentDescription = "Icone linkedin",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .align(Alignment.BottomEnd)
                                                .padding(end = 5.dp)
                                        )
                                    }
                                }
                                item {
                                    Text(
                                        text = "https://www.linkedin.com/in/coline-auber-0a9286197/",
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                            }
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(onClick = { navController.navigate("FilmsComposant") }) {
                                Text("Démarrer")
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
                    Row(

                        modifier = Modifier.fillMaxSize()
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painterResource(id = R.drawable.selfie),
                                contentDescription = "Photo Coline",
                                modifier = Modifier
                                    .size(300.dp)
                                    .padding(20.dp)
                                    .clip(CircleShape)
                            )

                            Text(
                                text = "Coline Auber",
                                style = MaterialTheme.typography.headlineLarge,
                            )

                            Text(
                                text = "Etudiante à l'école d'ingénieur ISIS - INU Champollion",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(10.dp)
                            )
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                Modifier
                                    .padding(top = 50.dp)
                                    .width(400.dp)
                            ) {
                                item {
                                    Box() {
                                        Image(
                                            painterResource(id = R.drawable.email),
                                            contentDescription = "Icone mail",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .padding(bottom = 5.dp, end = 5.dp)
                                                .align(Alignment.BottomEnd)
                                        )
                                    }
                                }
                                item {
                                    Text(
                                        text = "colineauber@yahoo.fr",
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                                item {
                                    Box() {
                                        Image(
                                            painterResource(id = R.drawable.linkedin),
                                            contentDescription = "Icone linkedin",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .align(Alignment.BottomEnd)
                                                .padding(end = 5.dp)
                                        )
                                    }
                                }
                                item {
                                    Text(
                                        text = "https://www.linkedin.com/in/coline-auber-0a9286197/",
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                            }
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(onClick = { navController.navigate("FilmsComposant") }) {
                                Text("Démarrer")
                            }
                        }

                    }
                }

            }
        }


    }
