package com.diagnese.app.core.data.network.disease

import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DiseaseApiService {

    @GET("glosarium")
    suspend fun getAllDiseaseData() : DiseaseResponse

    @POST("predict")
    suspend fun predictDisease(@Body predictRequest : JSONObject) : PostResponse

    @GET("predict")
    suspend fun getSymptoms() : PredictionResponse

}