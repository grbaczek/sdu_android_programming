package com.programming.android.sdu.databaseexercise.viewmodels

import androidx.lifecycle.ViewModel
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.repositories.UserRepository

class UserViewModel() : ViewModel() {

    lateinit var repository: UserRepository

    fun getUser() : User {
        if (count() == 0) {
            val currentUser = User()
            currentUser.uid = 1
            currentUser.address = ""
            currentUser.dateOfBirth = 0
            currentUser.name = ""
            insert(currentUser)
            return currentUser
        } else {
           return repository.getUser()
        }

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