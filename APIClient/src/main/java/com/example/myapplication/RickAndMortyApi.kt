package com.example.myapplication

import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}