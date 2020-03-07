package sdu.android.programming.com.fragment_exercise_1;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jakob on 05/03/2018.
 */

public class GreenFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_event", "GreenFragment onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_event", "GreenFragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_event", "GreenFragment onStart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_event", "GreenFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_green,container,false);
        Log.i("fragment_event", "GreenFragment onCreateView");
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_event", "GreenFragment onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_event", "GreenFragment onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("fragment_event", "GreenFragment onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("fragment_event", "GreenFragment onViewStateRestored");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_event", "GreenFragment onActivityCreated");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_event", "GreenFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_event", "GreenFragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_event", "GreenFragment onDestroy");
    }
}
