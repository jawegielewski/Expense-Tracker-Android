package pl.jawegiel.expensetrackerandroid.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import pl.jawegiel.expensetrackerandroid.data.model.Expense

class MainViewModel : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }


    fun getExpenses() {
        Log.d(TAG, "Get expenses clicked")
    }

    fun saveExpense() {
        Log.d(TAG, "Save expense clicked")
    }

    fun saveExpense(
        title: String,
        amount: String,
        category: String,
        date: String,
        description: String,
    ) {
        Log.d(TAG, "Saving expense: title=$title, amount=$amount, category=$category, date=$date, description=$description")
    }
}
