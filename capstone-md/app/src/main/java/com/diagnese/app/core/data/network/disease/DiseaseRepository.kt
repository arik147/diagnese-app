package com.diagnese.app.core.data.network.disease

import com.diagnese.app.core.data.network.NetworkDataSource
import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.repository.IDiseaseRepository
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject

class DiseaseRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : IDiseaseRepository {

    override suspend fun getAllDiseaseData(): Flow<Resource<DiseaseResponse>> {
        return networkDataSource.getAllDiseaseData()
    }

    override suspend fun predictDisease(predictRequest: JSONObject): Flow<Resource<PostResponse>> {
        return networkDataSource.predictDisease(predictRequest)
    }

    override suspend fun getSymptoms(): Flow<Resource<PredictionResponse>> {
        return networkDataSource.getSymptoms()
    }


}