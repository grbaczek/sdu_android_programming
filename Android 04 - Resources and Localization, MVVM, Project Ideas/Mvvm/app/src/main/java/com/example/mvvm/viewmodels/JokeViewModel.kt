package com.example.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.Joke
import com.example.mvvm.repository.JokeRepository

class JokeViewModel : ViewModel() {

    private val jokeRepository: JokeRepository = JokeRepository()
    private val joke = MutableLiveData<Joke>()

    fun getJoke(): LiveData<Joke>{
        return joke
    }

    fun randomJoke() {
        joke.value = jokeRepository.fetchRandomJoke()
    }
}