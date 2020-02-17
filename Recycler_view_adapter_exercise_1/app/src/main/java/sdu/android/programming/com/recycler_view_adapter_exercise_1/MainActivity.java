package sdu.android.programming.com.recycler_view_adapter_exercise_1;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * Views, adapters and managers used
     */
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Random Number Generator
     */
    private Random random;

    ArrayList<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * instantiates Random Number Generator
         * and uses it to create X amount of random numbers, to populate list
         */
        random = new Random();
        numbers = generateNumbers(200);

        /**
         * Bind s Recycler view with id, and sets variables
         */
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        /**
         * Layout Managers available, can be commented out if you wanna try some other
         */
//        layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        /**
         * Creates new CustomAdapter, with the dataset of numbers
         * and makes it the adapter for the recyclerview
         */
        adapter = new CustomAdapter(numbers);
        recyclerView.setAdapter(adapter);

    }

    /**
     * Generates X amount of random numbers between 0 and 10.000
     * @param amount
     * @return {@link ArrayList} of Integers
     */
    private ArrayList<Integer> generateNumbers(int amount) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tmp.add(random.nextInt(10000));
        }
        return tmp;
    }
}
