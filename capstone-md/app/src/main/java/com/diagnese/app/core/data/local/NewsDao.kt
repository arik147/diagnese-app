package com.diagnese.app.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getBookmarkedNews() : Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(newsEntity: NewsEntity)

    @Delete
    suspend fun deleteBookmark(newsEntity: NewsEntity)

}