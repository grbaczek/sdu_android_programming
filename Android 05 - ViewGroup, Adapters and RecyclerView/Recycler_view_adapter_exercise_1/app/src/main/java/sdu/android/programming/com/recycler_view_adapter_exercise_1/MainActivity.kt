package sdu.android.programming.com.recycler_view_adapter_exercise_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    /**
     * Views, adapters and managers used
     */
    private lateinit var recyclerView: RecyclerView
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    /**
     * Random Number Generator
     */
    private var random: Random? = null
    var numbers: ArrayList<Int>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * instantiates Random Number Generator
         * and uses it to create X amount of random numbers, to populate list
         */
        random = Random()
        numbers = generateNumbers(200)
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
        adapter = CustomAdapter(numbers!!)
        recyclerView.adapter = adapter
    }

    /**
     * Generates X amount of random numbers between 0 and 10.000
     * @param amount
     * @return [ArrayList] of Integers
     */
    private fun generateNumbers(amount: Int): ArrayList<Int> {
        val tmp = ArrayList<Int>()
        for (i in 0 until amount) {
            tmp.add(random!!.nextInt(10000))
        }
        return tmp
    }
}