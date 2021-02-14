package com.example.mvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.Joke
import com.example.mvvm.repository.JokeRepository

class UserViewModel : ViewModel() {

    private var jokeRepository: JokeRepository = JokeRepository()
    var joke = MutableLiveData<Joke>()

     fun randomJoke() {
        joke.value = jokeRepository.fetchRandomJoke()
    }
}