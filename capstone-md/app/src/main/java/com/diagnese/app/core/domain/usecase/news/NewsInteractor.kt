package com.diagnese.app.core.domain.usecase.news

import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.core.data.network.news.NewsResponse
import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository: INewsRepository) : NewsUseCase{

    override suspend fun getAllNews(
        key: String,
        country: String,
        category: String
    ): Flow<Resource<NewsResponse>> {
        return newsRepository.getAllNews(key)
    }

    override fun getBookmarkedNews(): Flow<List<NewsEntity>> {
        return newsRepository.getBookmarkedNews()
    }

    override suspend fun insertBookmark(newsEntity: NewsEntity) {
        return newsRepository.insertBookmark(newsEntity)
    }

    override suspend fun deleteBookmark(newsEntity: NewsEntity) {
        return newsRepository.deleteBookmark(newsEntity)
    }


}