package pl.jawegiel.expensetrackerandroid.data.datasource

import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import pl.jawegiel.expensetrackerandroid.data.model.Expense
import pl.jawegiel.expensetrackerandroid.data.remote.ExpenseApiService
import javax.inject.Inject

class ExpenseRemoteDataSourceImpl @Inject constructor(
    private val apiService: ExpenseApiService
) : ExpenseRemoteDataSource {

    companion object {
        private const val TAG = "ExpenseRemoteDataSource"
    }

    override suspend fun addExpense(expense: Expense) {
        apiService.createExpense(expense)
    }

    override fun getExpenses(): Flow<List<Expense>> = callbackFlow {
        try {
            val expenses = apiService.getExpenses()
            trySend(expenses)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to fetch expenses", e)
            trySend(emptyList())
        }
        awaitClose { }
    }
}
