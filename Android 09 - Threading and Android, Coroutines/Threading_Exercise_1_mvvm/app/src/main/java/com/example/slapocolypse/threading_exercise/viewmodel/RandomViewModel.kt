package com.example.slapocolypse.threading_exercise.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.slapocolypse.threading_exercise.model.RandomManager
import kotlinx.coroutines.*

class RandomViewModel : ViewModel() {

    // A coroutine job
    private lateinit var job: Job
    @Volatile
    private var running = true
    private val randomManager = RandomManager()
    private val _randomString = MutableLiveData<String>()
    val randomString: LiveData<String>
        get() = _randomString

    init {
        updateRandom()
    }

    private fun updateRandom() {
        // Launch coroutine in viewModelScope
       viewModelScope.launch {

               withContext(Dispatchers.IO){
                   while (running) {
                       // Create and post a random string
                       val newRandomString = randomManager.random()
                       _randomString.postValue(newRandomString)
                       // Suspend the coroutine for 5 seconds
                       delay(5000)
                   }
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