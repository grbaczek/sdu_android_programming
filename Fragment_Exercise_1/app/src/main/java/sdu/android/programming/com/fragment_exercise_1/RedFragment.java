package sdu.android.programming.com.fragment_exercise_1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jakob on 05/03/2018.
 */

public class RedFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_event", "RedFragment onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_event", "RedFragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_event", "RedFragment onStart");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_event", "RedFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_red,container,false);
        Log.i("fragment_event", "RedFragment onCreateView");
        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_event", "RedFragment onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_event", "RedFragment onPause");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_event", "RedFragment onActivityCreated");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_event", "RedFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_event", "RedFragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_event", "RedFragment onDestroy");
    }
}
