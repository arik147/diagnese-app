package com.diagnese.app.pages.glosary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diagnese.app.core.data.network.disease.DiseaseItem
import com.diagnese.app.core.data.network.disease.DiseaseResponse
import com.diagnese.app.core.domain.usecase.disease.DiseaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GlosaryViewModel @Inject constructor(private val diseaseUseCase: DiseaseUseCase): ViewModel() {

    private var _diseaseData = MutableLiveData<DiseaseResponse?>()

    private val _sortByAlphabet = MutableStateFlow(_diseaseData.value?.data?.sortedBy { it.prognosis }?.groupBy { it.prognosis[0] })
    val sortByAlphabet : StateFlow<Map<Char, List<DiseaseItem>>?> get() = _sortByAlphabet

    private val _query = mutableStateOf("")
    val query : State<String> get() = _query


    init {
        getAllDiseaseData()
    }

    private fun getAllDiseaseData() =
        viewModelScope.launch {
            diseaseUseCase.getAllDiseaseData().collect{
                _diseaseData.value = it.data
            }
        }

    fun searchDisease(query : String) : List<DiseaseItem>? {
        return _diseaseData.value?.data?.filter { item ->
            item.prognosis.contains(query, ignoreCase = true)
        }
    }

    fun search(query: String){
        _query.value = query
        _sortByAlphabet.value = searchDisease(_query.value)?.sortedBy { it.prognosis }?.groupBy { it.prognosis[0] }
    }

}