package com.programming.android.sdu.databaseexercise.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel() : ViewModel() {

    lateinit var repository: UserRepository

    fun getUser() : User {
        return repository.user
    }

    fun insert(user: User) {
        repository.insert(user)
    }

    fun update(user: User) {
        repository.update(user)
    }

    fun count(): Int {
        return repository.count()
    }
}