package com.cardlay.fragmentexercise1noappbar

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Jakob on 05/03/2018.
 */
class GreenFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("fragment_exercise", "GreenFragment onAttach")
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragment_exercise", "GreenFragment onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragment_exercise", "GreenFragment onStart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragment_exercise", "GreenFragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_green, container, false)
        Log.i("fragment_exercise", "GreenFragment onCreateView")
        return v
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fragment_exercise", "GreenFragment onDestroyView")
    }

    override fun onPause() {
        //DO NOTHING
        super.onPause()
        Log.i("fragment_exercise", "GreenFragment onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("fragment_exercise", "GreenFragment onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i("fragment_exercise", "GreenFragment onViewStateRestored")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("fragment_exercise", "GreenFragment onActivityCreated")
    }

    override fun onStop() {
        super.onStop()
        Log.i("fragment_exercise", "GreenFragment onStop")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("fragment_exercise", "GreenFragment onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragment_exercise", "GreenFragment onDestroy")
    }
}