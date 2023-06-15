package com.diagnese.app.core.di

import com.diagnese.app.core.data.network.disease.DiseaseRepository
import com.diagnese.app.core.data.network.news.NewsRepository
import com.diagnese.app.core.domain.repository.IAuthRepository
import com.diagnese.app.core.domain.repository.IDiseaseRepository
import com.diagnese.app.core.domain.repository.INewsRepository
import com.diagnese.app.core.firebase.FirebaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [FirebaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideFirebaseRepository(firebaseRepository: FirebaseRepository) : IAuthRepository

    @Binds
    abstract fun provideNewsRepository(newsRepository: NewsRepository) : INewsRepository

    @Binds
    abstract fun provideDiseaseRepository(diseaseRepository: DiseaseRepository) : IDiseaseRepository
}