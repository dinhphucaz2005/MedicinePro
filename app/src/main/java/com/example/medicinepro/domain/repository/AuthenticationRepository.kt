package com.example.medicinepro.domain.repository

import com.example.medicinepro.common.ApiResult
import com.example.medicinepro.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {

    suspend fun register(): Flow<ApiResult<User>>

}