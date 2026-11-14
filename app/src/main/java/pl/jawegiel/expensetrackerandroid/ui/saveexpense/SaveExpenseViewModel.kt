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
import pl.jawegiel.expensetrackerandroid.domain.usecase.ValidateExpenseUseCase
import pl.jawegiel.expensetrackerandroid.domain.usecase.ValidationResult
import javax.inject.Inject

@HiltViewModel
class SaveExpenseViewModel @Inject constructor(
    private val repository: ExpenseRepository,
    private val validateExpenseUseCase: ValidateExpenseUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "SaveExpenseViewModel"
    }

    var name by mutableStateOf("")
    var price by mutableStateOf("")
    var dateMillis by mutableStateOf("")
    var selectedMillis: Long? = null

    fun validateAndSave(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val validationResult = validateExpenseUseCase(
            name = name,
            price = price,
            dateMillis = dateMillis,
            selectedMillis = selectedMillis
        )

        when (validationResult) {
            is ValidationResult.Success -> {
                val priceInt = price.toBigDecimal().toInt()
                saveExpenseConfirmed(selectedMillis!!, priceInt, onSuccess, onError)
            }
            is ValidationResult.Error -> onError(validationResult.message)
        }
    }

    private fun saveExpenseConfirmed(
        millis: Long,
        priceInt: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        Log.d(TAG, "Saving expense: name=$name, price=$priceInt, date=$millis")

        viewModelScope.launch {
            try {
                val expense = Expense(
                    id = null,
                    name = name,
                    price = priceInt,
                    dateMillis = millis
                )
                repository.addExpense(expense)

                clearFields()

                onSuccess()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save expense", e)
                onError(e.localizedMessage ?: "Failed to save expense")
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
