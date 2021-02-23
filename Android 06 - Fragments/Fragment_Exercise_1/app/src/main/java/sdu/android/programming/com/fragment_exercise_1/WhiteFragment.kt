package sdu.android.programming.com.fragment_exercise_1

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
class WhiteFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("fragment_exercise", "WhiteFragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragment_exercise", "WhiteFragment onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("fragment_exercise", "WhiteFragment onActivityCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragment_exercise", "WhiteFragment onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragment_exercise", "WhiteFragment onStart")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_white, container, false)
        return v
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fragment_exercise", "WhiteFragment onDestroyView")
    }

    override fun onPause() {
        //DO NOTHING
        super.onPause()
        Log.i("fragment_exercise", "WhiteFragment onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("fragment_exercise", "WhiteFragment onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i("fragment_exercise", "WhiteFragment onViewStateRestored")
    }

    override fun onStop() {
        super.onStop()
        Log.i("fragment_exercise", "WhiteFragment onStop")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("fragment_exercise", "WhiteFragment onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragment_exercise", "WhiteFragment onDestroy")
    }
}