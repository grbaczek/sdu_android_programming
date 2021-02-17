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
class BlueFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("fragment_exercise", "BlueFragment onAttach")
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragment_exercise", "BlueFragment onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragment_exercise", "BlueFragment onStart")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("fragment_exercise", "BlueFragment onActivityCreated")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fragment_exercise", "BlueFragment onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_blue, container, false)
        Log.i("fragment_exercise", "BlueFragment onCreateView")
        return v
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("fragment_exercise", "BlueFragment onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i("fragment_exercise", "BlueFragment onViewStateRestored")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fragment_exercise", "BlueFragment onDestroyView")
    }

    override fun onPause() {
        //DO NOTHING
        super.onPause()
        Log.i("fragment_exercise", "BlueFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("fragment_exercise", "BlueFragment onStop")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("fragment_exercise", "BlueFragment onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragment_exercise", "BlueFragment onDestroy")
    }
}