package com.example.medicinepro.data.remote

import com.example.medicinepro.domain.service.SongApi
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

class SongApiImpl @Inject constructor(
    private val httpClient: HttpClient
) : SongApi {
    override suspend fun getFacts(): HttpResponse {
        return httpClient.get("/fact")
    }
}