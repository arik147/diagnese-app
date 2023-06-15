package com.diagnese.app.pages.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diagnese.app.BuildConfig
import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.core.data.network.news.NewsResponse
import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.usecase.firebase.FirebaseUseCase
import com.diagnese.app.core.domain.usecase.news.NewsUseCase
import com.google.firebase.database.DataSnapshot
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsUseCase: NewsUseCase, private val firebaseUseCase: FirebaseUseCase) : ViewModel() {

    init {
        getAllNews(BuildConfig.API_KEY)
        getUser()
    }


    private val _newsPagingData = MutableLiveData<Resource<NewsResponse>>()
    val newsPagingData : LiveData<Resource<NewsResponse>> = _newsPagingData

    private val _loginResultState = MutableLiveData<DataSnapshot?>()
    val loginResultState : LiveData<DataSnapshot?> = _loginResultState


    private fun getUser() = viewModelScope.launch {
        val user = firebaseUseCase.getUser()
        _loginResultState.value = user
    }

   private fun getAllNews(key : String) = viewModelScope.launch {
        newsUseCase.getAllNews(key).collect{ response ->
            _newsPagingData.value = response
        }
    }

   fun insertBookmark(newsEntity: NewsEntity){
       viewModelScope.launch {
           newsUseCase.insertBookmark(newsEntity)
       }
   }

    fun deleteBookmark(newsEntity: NewsEntity){
        viewModelScope.launch {
            newsUseCase.deleteBookmark(newsEntity)
        }
    }
}