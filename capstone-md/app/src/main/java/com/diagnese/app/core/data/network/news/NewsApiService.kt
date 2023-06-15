package com.diagnese.app.core.data.network.news


import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("apiKey") key : String,
        @Query("country") country : String,
        @Query("category") category: String,
    ) : NewsResponse


}