package com.diagnese.app.di

import com.diagnese.app.core.domain.usecase.disease.DiseaseInteractor
import com.diagnese.app.core.domain.usecase.disease.DiseaseUseCase
import com.diagnese.app.core.domain.usecase.firebase.FirebaseInteractor
import com.diagnese.app.core.domain.usecase.firebase.FirebaseUseCase
import com.diagnese.app.core.domain.usecase.news.NewsInteractor
import com.diagnese.app.core.domain.usecase.news.NewsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideFirebaseUseCase(firebaseInteractor: FirebaseInteractor) : FirebaseUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideNewsUseCase(newsInteractor: NewsInteractor) : NewsUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideDiseaseUseCase(diseaseInteractor: DiseaseInteractor) : DiseaseUseCase


}