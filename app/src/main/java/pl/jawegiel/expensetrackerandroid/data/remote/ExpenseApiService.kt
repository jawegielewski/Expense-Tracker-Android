package pl.jawegiel.expensetrackerandroid.data.remote

import pl.jawegiel.expensetrackerandroid.data.model.Expense
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ExpenseApiService {

    @GET("get-expenses")
    suspend fun getExpenses(): List<Expense>

    @POST("save-expense")
    suspend fun createExpense(@Body expense: Expense)
}