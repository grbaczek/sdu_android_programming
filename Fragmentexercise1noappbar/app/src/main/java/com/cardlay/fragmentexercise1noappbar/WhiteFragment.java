package com.cardlay.fragmentexercise1noappbar;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * Created by Jakob on 05/03/2018.
 */

public class WhiteFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_exercise", "WhiteFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_exercise", "WhiteFragment onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_exercise", "WhiteFragment onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_exercise", "WhiteFragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_exercise", "WhiteFragment onStart");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_white,container,false);
        Log.i("fragment_exercise", "WhiteFragment onCreateView");
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_exercise", "WhiteFragment onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_exercise", "WhiteFragment onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("fragment_exercise", "WhiteFragment onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("fragment_exercise", "WhiteFragment onViewStateRestored");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_exercise", "WhiteFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_exercise", "WhiteFragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_exercise", "WhiteFragment onDestroy");
    }
}
