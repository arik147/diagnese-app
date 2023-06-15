package com.diagnese.app.pages.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.core.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel() {

    val newsList = newsUseCase.getBookmarkedNews().asLiveData()

    fun deleteBookmark(newsEntity: NewsEntity){
        viewModelScope.launch {
            newsUseCase.deleteBookmark(newsEntity)
        }
    }

}