package com.example.premiere_application

import retrofit2.http.GET
import retrofit2.http.Query


interface TMDB_API {

    @GET("trending/movie/week")
    suspend fun derniers_films(@Query("api_key") api_key: String): Films

    @GET("trending/tv/week")
    suspend fun dernieres_series(@Query("api_key") api_key: String): Series

    @GET("trending/person/week")
    suspend fun dernieres_personnes(@Query("api_key") api_key: String): Personnes

}