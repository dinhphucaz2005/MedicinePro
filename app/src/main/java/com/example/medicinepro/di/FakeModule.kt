package com.example.medicinepro.di

import com.example.medicinepro.domain.repository.AuthenticationRepository
import com.example.medicinepro.ui.screen.authentication.login.LoginViewModel
import com.example.medicinepro.ui.screen.authentication.register.RegisterViewModel

object FakeModule {

    private val authenticationRepository = object : AuthenticationRepository {
        override suspend fun register() {

        }
    }

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(authenticationRepository)
    }

    fun provideRegisterViewModel(): RegisterViewModel {
        return RegisterViewModel(authenticationRepository)
    }

}