package com.diagnese.app.core.di

import android.content.Context
import androidx.room.Room
import com.diagnese.app.core.data.local.NewsDao
import com.diagnese.app.core.data.local.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(@ApplicationContext context : Context) : NewsDatabase{
        return Room.databaseBuilder(context, NewsDatabase::class.java, "news_db").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providesNewsDao(database: NewsDatabase) : NewsDao = database.newsDao()

}