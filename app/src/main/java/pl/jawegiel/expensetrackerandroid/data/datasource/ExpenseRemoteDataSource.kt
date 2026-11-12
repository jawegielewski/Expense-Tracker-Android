package pl.jawegiel.expensetrackerandroid.data.datasource

import kotlinx.coroutines.flow.Flow
import pl.jawegiel.expensetrackerandroid.data.model.Expense

interface ExpenseRemoteDataSource {
    suspend fun addExpense(expense: Expense)
    fun getExpenses(): Flow<List<Expense>>
}