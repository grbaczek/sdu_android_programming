package com.example.slapocolypse.threading_exercise;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by slapocolypse on 3/12/18.
 */

public interface JokeService {
    @GET("jokes/random")
    Call<Joke> randomJoke();
}
