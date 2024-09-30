package com.ravi.weatherapp.network


import com.ravi.weatherapp.data.GeocodingResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.openweathermap.org/geo/1.0/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GeocodingApiService {

    @GET("direct")
    suspend fun getCityCode(
        @Query("q") city: String,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String
    ): List<GeocodingResponse>
}

object GeocodingApi {
    val retrofitService: GeocodingApiService by lazy {
        retrofit.create(GeocodingApiService::class.java)
    }
}