package com.diagnese.app.core.data.local


import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val newsDao: NewsDao
) {

    fun getBookmarkedNews() : Flow<List<NewsEntity>>{
        return newsDao.getBookmarkedNews()
    }

    suspend fun insertBookmark(newsEntity: NewsEntity){
        newsDao.insertBookmark(newsEntity)
    }


    suspend fun deleteBookmark(newsEntity: NewsEntity){
        newsDao.deleteBookmark(newsEntity)
    }


}