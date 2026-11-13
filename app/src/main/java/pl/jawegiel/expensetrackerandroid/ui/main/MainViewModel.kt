package pl.jawegiel.expensetrackerandroid.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel

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
}
