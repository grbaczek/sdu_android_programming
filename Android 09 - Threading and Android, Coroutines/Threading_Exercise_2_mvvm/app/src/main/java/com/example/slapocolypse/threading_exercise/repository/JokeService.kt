package com.example.slapocolypse.threading_exercise.repository

import com.example.slapocolypse.threading_exercise.model.Joke
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by slapocolypse on 3/12/18.
 */
interface JokeService {
    @GET("jokes/random")
    suspend fun randomJoke(): Response<Joke>
}