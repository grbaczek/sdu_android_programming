package com.programming.android.sdu.serviceexercise

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by slapocolypse on 3/12/18.
 */
interface JokeWebService {
    @GET("jokes/random")
    fun randomJoke(): Call<Joke?>?
}