package com.programming.android.sdu.databaseexercise.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.programming.android.sdu.databaseexercise.databinding.FragmentSummaryBinding
import com.programming.android.sdu.databaseexercise.viewmodels.UserViewModel

class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        userViewModel.init()
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding.user = userViewModel
        return binding.root
    }

}