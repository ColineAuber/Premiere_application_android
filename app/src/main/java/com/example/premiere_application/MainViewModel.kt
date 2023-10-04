package com.example.premiere_application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel(){
    val films = MutableStateFlow<List<Film>>(listOf())
    val series = MutableStateFlow<List<Serie>>(listOf())
    val personnes = MutableStateFlow<List<Personne>>(listOf())

    val apikey = "d936676cee467fd5bde1950ab82959ee"

    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TMDB_API::class.java)

    // TODO : Si la liste des films est vide, le composant doit appeler la fonction
    //  getFilmsInitiaux du ViewModel (et uniquement si elle est vide, sinon à chaque fois que le
    //  composant sera rafraichi, il demandera le téléchargement de la liste, ce qui provoquera à
    //  nouveau son rafraichissement, et donc une boucle infinie).

    fun films_tendance(){
        viewModelScope.launch {
            films.value = service.derniers_films(apikey).results
        }
    }

    fun series_tendance(){
        viewModelScope.launch {
            series.value = service.dernieres_series(apikey).results
        }
    }

    fun personnes_tendance(){
        viewModelScope.launch {
            personnes.value = service.dernieres_personnes(apikey).results
        }
    }

}