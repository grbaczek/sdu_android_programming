package com.example.slapocolypse.threading_exercise.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {

    private val url = "https://api.icndb.com/"
    private var retrofit: Retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private var jokeService: JokeService = retrofit.create(JokeService::class.java)

    fun getJokeService(): JokeService {
        return jokeService
    }

}