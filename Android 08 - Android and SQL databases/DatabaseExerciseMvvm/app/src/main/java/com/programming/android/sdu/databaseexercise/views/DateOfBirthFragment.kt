package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.programming.android.sdu.databaseexercise.R
import com.programming.android.sdu.databaseexercise.database.User
import com.programming.android.sdu.databaseexercise.databinding.FragmentDateOfBirthBinding
import com.programming.android.sdu.databaseexercise.viewmodels.UserViewModel
import java.util.*

class DateOfBirthFragment : Fragment() {

    private lateinit var dpDateOfBirth: DatePicker
    private lateinit var user: User
    private lateinit var binding: FragmentDateOfBirthBinding
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        userViewModel.init()
        user = userViewModel.currentUser!!

        binding = FragmentDateOfBirthBinding.inflate(inflater, container, false)
        dpDateOfBirth = binding.dateOfBirthPicker
        dpDateOfBirth.updateDate(1986, 4, 14)
        binding.btnNext.setOnClickListener { redirectToNextActivity() }

        if (user.dateOfBirth != 0L) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = user.dateOfBirth
            dpDateOfBirth.updateDate(calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH])
        }

        return binding.root
    }

    private fun redirectToNextActivity() {
        val day = dpDateOfBirth.dayOfMonth
        val month = dpDateOfBirth.month
        val year = dpDateOfBirth.year
        val calendar = Calendar.getInstance()
        calendar[year, month] = day
        user.dateOfBirth = calendar.timeInMillis
        userViewModel.update(user)
        Navigation.findNavController(requireView()).navigate(R.id.action_dateOfBirthFragment_to_summaryFragment)
    }

}