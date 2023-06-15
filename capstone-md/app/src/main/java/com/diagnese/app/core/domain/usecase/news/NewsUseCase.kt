package com.diagnese.app.core.domain.usecase.news

import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.core.data.network.news.NewsResponse
import com.diagnese.app.core.data.state.Resource
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    suspend fun getAllNews(
         key : String,
        country : String = "id",
         category: String = "health"
    ) : Flow<Resource<NewsResponse>>

    fun getBookmarkedNews() : Flow<List<NewsEntity>>

    suspend fun insertBookmark(newsEntity: NewsEntity)

    suspend fun deleteBookmark(newsEntity: NewsEntity)
}