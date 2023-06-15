package com.diagnese.app.pages.checkup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diagnese.app.core.data.network.disease.PostResponse
import com.diagnese.app.core.data.network.disease.PredictionResponse
import com.diagnese.app.core.domain.usecase.disease.DiseaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class CheckupViewModel @Inject constructor(private val diseaseUseCase: DiseaseUseCase) : ViewModel() {

    init{
        getSymptoms()
    }

    private val _predictResponse = MutableLiveData<PostResponse>()
    val predictResponse : LiveData<PostResponse> = _predictResponse

    private val _symptomsData = MutableLiveData<PredictionResponse>()
    val symptomsData : LiveData<PredictionResponse> = _symptomsData

    fun predictDiseaseData(predictData : JSONObject){
        viewModelScope.launch {
            diseaseUseCase.predictDisease(predictData).collect{ response ->
                _predictResponse.value = response.data!!
            }
        }
    }

    private fun getSymptoms() = viewModelScope.launch {
        diseaseUseCase.getSymptoms().collect{ response ->
            _symptomsData.value = response.data!!
        }
    }


}