package pl.jawegiel.expensetrackerandroid.ui.saveexpense

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.jawegiel.expensetrackerandroid.data.model.Expense
import pl.jawegiel.expensetrackerandroid.domain.repository.ExpenseRepository
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class SaveExpenseViewModel @Inject constructor(
    private val repository: ExpenseRepository,
) : ViewModel() {

    companion object {
        private const val TAG = "SaveExpenseViewModel"
    }

    var name by mutableStateOf("")
    var price by mutableStateOf("")
    var dateMillis by mutableStateOf("")
    var selectedMillis: Long? = null

    fun validateAndSave(onSuccess: () -> Unit, onError: (String) -> Unit) {
        // Name validation
        if (name.isBlank()) {
            onError("Name is required")
            return
        }
        if (!name.matches(Regex("^[^0-9]*$"))) {
            onError("Name must not contain numbers")
            return
        }
        if (name.length !in 3..50) {
            onError("Name must be of length between 3-50")
            return
        }

        // Price validation
        if (price.isBlank()) {
            onError("Price is required")
            return
        }
        val bigDecimalPrice = price.toBigDecimalOrNull()
        if (bigDecimalPrice == null || bigDecimalPrice <= BigDecimal.ZERO) {
            onError("Price must be greater than zero")
            return
        }
        if (bigDecimalPrice.scale() > 2) {
            onError("Price format must be up to 6 digits and 2 decimals")
            return
        }
        val intVal = bigDecimalPrice.setScale(0, RoundingMode.DOWN).toBigInteger().abs()
        if (intVal.toString().length > 6) {
            onError("Price format must be up to 6 digits and 2 decimals")
            return
        }

        // Date validation
        if (selectedMillis == null || dateMillis.isBlank()) {
            onError("Date is required")
            return
        }
        val millis = selectedMillis!!
        if (millis < 1000000000000L) {
            onError("Date is not correct")
            return
        }
        if (millis.toString().length > 13) {
            onError("Date is not correct")
            return
        }

        saveExpenseConfirmed(millis, bigDecimalPrice.toInt(), onSuccess)
    }

    private fun saveExpenseConfirmed(millis: Long, priceInt: Int, onSuccess: () -> Unit) {
        Log.d(TAG, "Saving expense: name=$name, price=$priceInt, date=$millis")
        viewModelScope.launch {
            try {
                val expense = Expense(
                    id = null,
                    name = name,
                    price = priceInt,
                    dateMillis = millis,
                )
                repository.addExpense(expense)

                clearFields()

                onSuccess()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save expense", e)
            }
        }
    }

    private fun clearFields() {
        name = ""
        price = ""
        dateMillis = ""
        selectedMillis = null
    }
}
