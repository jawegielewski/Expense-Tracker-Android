package pl.jawegiel.expensetrackerandroid.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface AiApiService {

    @GET("best-gas-station/{city}")
    suspend fun getRecommendation(@Path("city") city: String): String
}