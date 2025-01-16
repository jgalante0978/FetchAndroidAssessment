package com.example.fetchtakehome_josephgalante.data.repository

import com.example.fetchtakehome_josephgalante.data.data.Item
import com.example.fetchtakehome_josephgalante.data.remote.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val api: Api): ApiRepository {
    override suspend fun doNetworkRequest(): Flow<Response<List<Item>>> {
        return flow {
            emit(api.doNetworkRequest())
        }
    }
}