package com.programming.android.sdu.databaseexercise.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.repositories.UserRepository
import java.text.SimpleDateFormat

class UserViewModel : ViewModel() {

    lateinit var repository: UserRepository
    var currentUser: User? = null
    var name = ObservableField<String>()
    var address = ObservableField<String>()
    var dateOfBirth = ObservableField<String>()

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
        name.set(currentUser!!.name)
        address.set(currentUser!!.address)
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formattedDate = sdf.format(currentUser!!.dateOfBirth)
        dateOfBirth.set(formattedDate)
    }

    private fun insert(user: User) {
        repository.insert(user)
    }

    fun update(user: User) {
        repository.update(user)
    }

    private fun count(): Int {
        return repository.count()
    }

    private fun createNewUser(): User {
        val newUser = User()
        newUser.uid = 1
        newUser.address = ""
        newUser.dateOfBirth = 0
        newUser.name = ""
        return newUser
    }
}