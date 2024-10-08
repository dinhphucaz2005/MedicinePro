package com.example.medicinepro.di

import android.app.Application
import android.content.Context
import com.example.medicinepro.data.repository.AuthenticationRepositoryImpl
import com.example.medicinepro.domain.repository.AuthenticationRepository
import com.example.medicinepro.domain.service.SongApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }


    @Provides
    @Singleton
    fun provideAuthenticationRepository(songApi: SongApi): AuthenticationRepository {
        return AuthenticationRepositoryImpl(songApi)
    }


}