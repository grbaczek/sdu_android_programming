package sdu.android.programming.com.recycler_view_adapter_exercise_1.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sdu.android.programming.com.recycler_view_adapter_exercise_1.R
import sdu.android.programming.com.recycler_view_adapter_exercise_1.models.NumberModel

/**
 * Created by Jakob on 27/02/2018.
 */
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var numbers: ArrayList<NumberModel>

    /**
     * Sets the numbers for the adapter and notify that data has changed
     * @param numberList
     */
    fun setNumbers(numberList: ArrayList<NumberModel>) {
        numbers = numberList
        notifyDataSetChanged()
    }

    /**
     * Creates the viewholder
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.random_textview, parent, false)
        val tv = v.findViewById<TextView>(R.id.test_tv)
        return ViewHolder(v, tv)
    }

    /**
     * Binds current viewholder, and creates on click listener for each item
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = String.format("Setting textview for position: %s", position)
        Log.i("CustomAdapter", message)
        holder.textView.text = numbers.get(position).value.toString()
    }

    override fun getItemCount(): Int {
        Log.i("CustomAdapter", String.format("Getting item count: %s", numbers.size))
        return numbers.size
    }

    class ViewHolder(frameLayout: View?, // each data item is just a string in this case
                     val textView: TextView) : RecyclerView.ViewHolder(frameLayout!!)

}