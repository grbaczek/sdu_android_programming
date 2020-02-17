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

public class WhiteFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_event", "WhiteFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_event", "WhiteFragment onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_event", "WhiteFragment onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_event", "WhiteFragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_event", "WhiteFragment onStart");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_white,container,false);
        Log.i("fragment_event", "WhiteFragment onCreateView");
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_event", "WhiteFragment onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_event", "WhiteFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_event", "WhiteFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_event", "WhiteFragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_event", "WhiteFragment onDestroy");
    }
}
