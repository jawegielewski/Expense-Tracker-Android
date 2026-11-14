package pl.jawegiel.expensetrackerandroid.data.repository

import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import pl.jawegiel.expensetrackerandroid.data.datasource.ExpenseRemoteDataSourceImpl
import pl.jawegiel.expensetrackerandroid.data.model.Expense
import pl.jawegiel.expensetrackerandroid.domain.repository.ExpenseRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepositoryImpl @Inject constructor(
    private val expenseRemoteDataSourceImpl: ExpenseRemoteDataSourceImpl
) : ExpenseRepository {

    override suspend fun addExpense(expense: Expense) {
        expenseRemoteDataSourceImpl.addExpense(expense)
    }

    override fun getExpenses() = flow {
        emitAll(expenseRemoteDataSourceImpl.getExpenses())
    }
}