package pl.jawegiel.expensetrackerandroid.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.jawegiel.expensetrackerandroid.data.model.Expense

interface ExpenseRepository {
    suspend fun addExpense(expense: Expense)
    fun getExpenses(): Flow<List<Expense>>
}