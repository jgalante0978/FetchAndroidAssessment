package com.example.fetchtakehome_josephgalante.data.remote

import com.example.fetchtakehome_josephgalante.data.data.Item
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(Utils.Endpoint)
    suspend fun doNetworkRequest(): Response<List<Item>>

}