package sdu.android.programming.com.recycler_view_adapter_exercise_1.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sdu.android.programming.com.recycler_view_adapter_exercise_1.R
import sdu.android.programming.com.recycler_view_adapter_exercise_1.viewmodels.NumberViewModel

class MainActivity : AppCompatActivity(), CustomAdapter.ViewHolderListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private val numberViewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Bind s Recycler view with id, and sets variables
         */
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        /**
         * Layout Managers available, can be commented out if you wanna try some other
         */
        //layoutManager = LinearLayoutManager(this);
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        /**
         * Creates new CustomAdapter, with the dataset of numbers
         * and makes it the adapter for the recyclerview
         */
        adapter = CustomAdapter(this)
        adapter.setNumbers(numberViewModel.getNumbers().value!!)
        recyclerView.adapter = adapter

        numberViewModel.getNumbers().observe(this, { numbers ->
            adapter.setNumbers(numbers)
        })

    }

    override fun deleteNumberOnClick(position: Int) {
        numberViewModel.deleteNumber(position)
    }

    override fun addNumberOnClick(position: Int, number: Int) {
        numberViewModel.addNumber(position, number)
    }

}