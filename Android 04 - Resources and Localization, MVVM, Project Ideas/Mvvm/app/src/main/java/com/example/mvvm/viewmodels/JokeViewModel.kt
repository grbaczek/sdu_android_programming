package com.example.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.Joke
import com.example.mvvm.repository.JokeRepository

class JokeViewModel : ViewModel() {

    private val jokeRepository: JokeRepository = JokeRepository()
    private val _joke = MutableLiveData<Joke>()

    val joke: LiveData<Joke>
        get() = _joke

    fun randomJoke() {
        _joke.value = jokeRepository.fetchRandomJoke()
    }
}