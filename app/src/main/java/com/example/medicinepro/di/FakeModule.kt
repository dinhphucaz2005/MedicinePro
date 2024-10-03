package com.example.medicinepro.di

import com.example.medicinepro.domain.repository.AuthenticationRepository
import com.example.medicinepro.ui.screen.authentication.login.LoginViewModel

object FakeModule {

    private val authenticationRepository = object :AuthenticationRepository {
        override suspend fun register() {

        }
    }

    fun provideLoginViewModel(): LoginViewModel{
        return LoginViewModel(authenticationRepository)
    }

}