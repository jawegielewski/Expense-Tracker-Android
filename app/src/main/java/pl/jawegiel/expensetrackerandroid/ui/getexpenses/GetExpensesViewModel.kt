package pl.jawegiel.expensetrackerandroid.ui.getexpenses

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.jawegiel.expensetrackerandroid.data.model.Expense
import pl.jawegiel.expensetrackerandroid.data.remote.ExpenseApiService
import pl.jawegiel.expensetrackerandroid.domain.repository.ExpenseRepository
import javax.inject.Inject

@HiltViewModel
class GetExpensesViewModel @Inject constructor(
    private val repository: ExpenseRepository, private val expenseApiService: ExpenseApiService
) : ViewModel() {

    var expenses by mutableStateOf<List<Expense>>(emptyList())
        private set
    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    val expensesState: StateFlow<List<Expense>> = repository.getExpenses().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init {
        fetchExpenses()
    }

    fun fetchExpenses() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                expenses = expenseApiService.getExpenses()
            } catch (e: Exception) {
                errorMessage = e.localizedMessage ?: "Failed to load expenses"
            } finally {
                isLoading = false
            }
        }
    }
}
