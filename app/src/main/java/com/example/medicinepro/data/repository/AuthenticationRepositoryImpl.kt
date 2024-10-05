package com.example.medicinepro.data.repository

import com.example.medicinepro.common.ApiResult
import com.example.medicinepro.domain.model.User
import com.example.medicinepro.domain.repository.AuthenticationRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class AuthenticationRepositoryImpl(private val httpClient: HttpClient) : AuthenticationRepository {
    override suspend fun register(): Flow<ApiResult<User>> {
        TODO("Not yet implemented")
    }
}