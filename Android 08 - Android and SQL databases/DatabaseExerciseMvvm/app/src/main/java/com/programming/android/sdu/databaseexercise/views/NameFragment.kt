package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.programming.android.sdu.databaseexercise.R
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.databinding.FragmentNameBinding
import com.programming.android.sdu.databaseexercise.viewmodels.UserViewModel

class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding
    private lateinit var etYourName: EditText
    private lateinit var user: User
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        userViewModel.init()
        user = userViewModel.currentUser!!
        binding = FragmentNameBinding.inflate(inflater, container, false)
        etYourName = binding.etYourName
        binding.btnNext.setOnClickListener{ redirectToNextActivity() }
        if (!TextUtils.isEmpty(user.name)) {
            etYourName.setText(user.name)
        }
        return  binding.root
    }

    private fun redirectToNextActivity() {
        if (!TextUtils.isEmpty(etYourName.text)) {
            user.name = etYourName.text.toString()
            userViewModel.update(user)
            Navigation.findNavController(requireView()).navigate(R.id.action_nameFragment_to_addressFragment)
        }
    }

}