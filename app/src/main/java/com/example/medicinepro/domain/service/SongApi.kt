package com.example.medicinepro.domain.service

import io.ktor.client.statement.HttpResponse

interface SongApi {
    suspend fun getFacts(): HttpResponse
}