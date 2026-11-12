package pl.jawegiel.expensetrackerandroid.ui.gasstation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.jawegiel.expensetrackerandroid.data.model.Expense
import pl.jawegiel.expensetrackerandroid.domain.repository.ExpenseRepository
import javax.inject.Inject

@HiltViewModel
class GasStationViewModel @Inject constructor(
    private val repository: ExpenseRepository
) : ViewModel() {

    companion object {
        private const val TAG = "GasStationViewModel"
    }

    private val _bottomSheetText = MutableStateFlow<Expense?>(null)
    val bottomSheetText: StateFlow<Expense?> = _bottomSheetText.asStateFlow()

    fun onExpenseChange(expense: Expense) {
        _bottomSheetText.value?.name = expense.name
        _bottomSheetText.value?.price = expense.price
//        _bottomSheetText.value?.date = expense.date
    }

    fun submitData() {
        val dataToSave: Expense? = _bottomSheetText.value
        if (dataToSave != null) {
            addExpense(dataToSave)
            clearText()
        }
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            repository.addExpense(expense)
        }
    }

    fun clearText() {
        _bottomSheetText.value = null
    }
}
