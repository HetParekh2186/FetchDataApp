package com.example.fetchdataapp
import retrofit2.http.GET

interface FetchService {
    @GET("hiring.json")
    suspend fun getItems(): List<FetchItem>
}