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

public class BlueFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_event", "BlueFragment onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_event", "BlueFragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_event", "BlueFragment onStart");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_event", "BlueFragment onActivityCreated");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_event", "BlueFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blue,container,false);
        Log.i("fragment_event", "BlueFragment onCreateView");
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("fragment_event", "BlueFragment onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("fragment_event", "BlueFragment onViewStateRestored");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_event", "BlueFragment onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_event", "BlueFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_event", "BlueFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_event", "BlueFragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_event", "BlueFragment onDestroy");
    }
}
