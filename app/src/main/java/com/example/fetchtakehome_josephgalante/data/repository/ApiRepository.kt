package com.example.fetchtakehome_josephgalante.data.repository

import com.example.fetchtakehome_josephgalante.data.data.Item
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiRepository {
    suspend fun doNetworkRequest(): Flow<Response<List<Item>>>
}