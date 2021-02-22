package sdu.android.programming.com.recycler_view_adapter_exercise_1.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sdu.android.programming.com.recycler_view_adapter_exercise_1.models.NumberModel
import java.util.*
import kotlin.collections.ArrayList

class NumberViewModel : ViewModel() {

    private var numbers = MutableLiveData<ArrayList<NumberModel>>()
    private val numberList = ArrayList<NumberModel>()
    private val random = Random()

    init {
        populateNumbers(200)
        numbers.value = numberList
    }

    fun getNumbers(): LiveData<ArrayList<NumberModel>> {
        return numbers
    }

    private fun populateNumbers(amount: Int) {
        for (i in 0 until amount) {
            numberList.add(NumberModel(random.nextInt(10000)))
        }
    }

    fun deleteNumber(position: Int) {
        numbers.value?.removeAt(position)
        numbers.value = numbers.value
    }

    fun addNumber(position: Int, number: Int) {
        numbers.value?.add(position, NumberModel(number))
        numbers.value = numbers.value
    }

}