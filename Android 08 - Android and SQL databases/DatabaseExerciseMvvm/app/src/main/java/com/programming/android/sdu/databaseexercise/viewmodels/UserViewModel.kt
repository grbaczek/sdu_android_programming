package com.programming.android.sdu.databaseexercise.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.repositories.UserRepository

class UserViewModel() : ViewModel() {

    lateinit var repository: UserRepository
    var currentUser: User? = null
    var name: String? = null
    var address: String? = null
    var dateOfBirth: Long? = null

    fun init() {
        if (currentUser == null) {
            if (count() == 0) {
                val newUser = createNewUser()
                insert(newUser)
                currentUser = newUser
            } else {
                currentUser = repository.getUser()
            }
        }
        name = currentUser!!.name
        address = currentUser!!.address
        dateOfBirth = currentUser!!.dateOfBirth
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

    fun createNewUser(): User {
        val newUser = User()
        newUser.uid = 1
        newUser.address = ""
        newUser.dateOfBirth = 0
        newUser.name = ""
        return newUser
    }
}