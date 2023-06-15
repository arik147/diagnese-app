package com.diagnese.app.core.domain.repository

import com.diagnese.app.core.data.network.disease.DiseaseResponse
import com.diagnese.app.core.data.network.disease.PostResponse
import com.diagnese.app.core.data.network.disease.PredictionResponse
import com.diagnese.app.core.data.state.Resource
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject


interface IDiseaseRepository {

    suspend fun getAllDiseaseData() : Flow<Resource<DiseaseResponse>>

    suspend fun predictDisease(predictRequest: JSONObject) : Flow<Resource<PostResponse>>

    suspend fun getSymptoms() : Flow<Resource<PredictionResponse>>


}