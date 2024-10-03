package com.example.medicinepro.data.repository

import com.example.medicinepro.domain.repository.AuthenticationRepository
import kotlinx.coroutines.delay

class AuthenticationRepositoryImpl : AuthenticationRepository {
    override suspend fun register() {
        delay(5000)
    }
}