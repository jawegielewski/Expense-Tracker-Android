package pl.jawegiel.expensetrackerandroid.data.datasource

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import pl.jawegiel.expensetrackerandroid.data.model.Expense
import pl.jawegiel.expensetrackerandroid.data.remote.ExpenseApiService
import javax.inject.Inject

class ExpenseRemoteDataSourceImpl @Inject constructor(
    private val apiService: ExpenseApiService
) : ExpenseRemoteDataSource {


    override suspend fun addExpense(expense: Expense) {
        TODO("Not yet implemented")
    }

    override fun getExpenses(): Flow<List<Expense>> = callbackFlow {
        trySend(apiService.getExpenses())
        awaitClose { }
    }
}