package sdu.android.programming.com.recycler_view_adapter_exercise_1.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import sdu.android.programming.com.recycler_view_adapter_exercise_1.R
import sdu.android.programming.com.recycler_view_adapter_exercise_1.models.NumberModel

/**
 * Created by Jakob on 27/02/2018.
 */
class CustomAdapter(private val listener: ViewHolderListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

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
        val vh = ViewHolder(v, tv)
        vh.textView.setOnClickListener { view -> deleteItem(vh.adapterPosition, view) }
        return vh
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

    /**
     * Deletes item at position
     * Creates a snackbar with the option to undo deletion
     * @param position
     * @param v View used for snackbar to find go back hierarychally and find coordinator layout
     */
    fun deleteItem(position: Int, v: View?) {
        val message = String.format("Removing item at position: %s with value: %s", position, numbers[position].value)
        Log.i("CustomAdapter", message)

        val number = numbers[position].value
        val snack = Snackbar.make(v!!, message, Snackbar.LENGTH_LONG)
        snack.setAction("Undo") {
            listener.addNumberOnClick(position, number)
        }
        snack.show()
        listener.deleteNumberOnClick(position)
    }

    /**
     * Interface to communicate with the activity as listener
     */
    interface ViewHolderListener {
        fun deleteNumberOnClick(position: Int)
        fun addNumberOnClick(position: Int, number: Int)
    }
}