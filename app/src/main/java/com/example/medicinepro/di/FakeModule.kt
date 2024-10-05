package com.example.medicinepro.di

import com.example.medicinepro.common.ApiResult
import com.example.medicinepro.domain.model.User
import com.example.medicinepro.domain.repository.AuthenticationRepository
import com.example.medicinepro.ui.screen.authentication.forget.ForgetPasswordViewModel
import com.example.medicinepro.ui.screen.authentication.login.LoginViewModel
import com.example.medicinepro.ui.screen.authentication.register.RegisterViewModel
import kotlinx.coroutines.flow.Flow

object FakeModule {

    private val authenticationRepository = object : AuthenticationRepository {
        override suspend fun register(): Flow<ApiResult<User>> {
            TODO("Not yet implemented")
        }
    }

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(authenticationRepository)
    }

    fun provideRegisterViewModel(): RegisterViewModel {
        return RegisterViewModel(authenticationRepository)
    }

    fun provideForgetPasswordViewModel(): ForgetPasswordViewModel {
        return ForgetPasswordViewModel(authenticationRepository)
    }

}