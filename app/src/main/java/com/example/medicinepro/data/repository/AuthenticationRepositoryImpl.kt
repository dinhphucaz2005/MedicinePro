package com.example.medicinepro.data.repository

import com.example.medicinepro.common.ApiResult
import com.example.medicinepro.domain.model.User
import com.example.medicinepro.domain.repository.AuthenticationRepository
import com.example.medicinepro.domain.service.SongApi
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthenticationRepositoryImpl(
    private val songApi: SongApi
) : AuthenticationRepository {
    override suspend fun register(): Flow<ApiResult<User>> = flow {
        emit(ApiResult.Success(data = songApi.getFacts().body<User>()))
    }
}