package com.example.slapocolypse.threading_exercise.viewmodel

import android.text.Html
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.slapocolypse.threading_exercise.repository.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    // A coroutine job
    private lateinit var job: Job
    @Volatile
    private var running = true
    private val jokeService = ServiceBuilder().getJokeService()
    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String>
        get() = _joke

    init {
        updateJoke()
    }

    fun updateJoke() {
        // Launch coroutine in viewModelScope
        viewModelScope.launch(Dispatchers.IO){
            while(running) {
                // Fetch a joke
                val joke = jokeService.randomJoke()
                val jokeText = Html.fromHtml(joke.body()!!.value!!.joke).toString()
                // Post the joke to live data
                _joke.postValue(jokeText)
                // Suspend the coroutine for 5 seconds
                delay(3000)
            }
        }
    }

    override fun onCleared() {
        running = false
        super.onCleared()
        // Cancel the coroutine job when the view model is no longer used
        //job.cancel()
    }

}