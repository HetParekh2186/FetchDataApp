package com.example.fetchdataapp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FetchRepository {
    private val service: FetchService = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FetchService::class.java)

    suspend fun getFilteredSortedItems(): Map<Int, List<FetchItem>> {
        val items = service.getItems()
            .filter { it.name?.isNotBlank() == true } // Remove items with null or blank names
            .sortedWith(compareBy({ it.listId }, { it.name })) // Sort by listId, then name
        return items.groupBy { it.listId }
    }
}