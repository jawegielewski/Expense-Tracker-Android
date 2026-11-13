package pl.jawegiel.expensetrackerandroid.data.remote

import pl.jawegiel.expensetrackerandroid.data.model.Expense
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AiApiService {

    @GET("best-gas-station/{city}")
    suspend fun getRecommendation(@Path("city") city: String): String
}