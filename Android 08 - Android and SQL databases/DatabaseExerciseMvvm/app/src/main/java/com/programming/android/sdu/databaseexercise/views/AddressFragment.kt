package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.programming.android.sdu.databaseexercise.R
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.databinding.FragmentAddressBinding
import com.programming.android.sdu.databaseexercise.viewmodels.UserViewModel

class AddressFragment : Fragment() {

    private lateinit var etYourAddress: EditText
    private lateinit var binding: FragmentAddressBinding
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var user: User

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        userViewModel.init()
        user = userViewModel.currentUser!!

        binding = FragmentAddressBinding.inflate(inflater, container, false)
        binding.user = userViewModel
        etYourAddress = binding.etYourAddress
        binding.btnNext.setOnClickListener { redirectToNextActivity() }
        return binding.root
    }

    private fun redirectToNextActivity() {
        if (!TextUtils.isEmpty(etYourAddress.text)) {
            user.address = etYourAddress.text.toString()
            userViewModel.update(user)
            Navigation.findNavController(requireView()).navigate(R.id.action_addressFragment_to_dateOfBirthFragment)
        }
    }

}