package com.example.eberryassignmentbyparisa.data.remote

import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TvShowsApi is an interface that defines the contract for retrieving data
 * from an external API.
 */

interface TvShowsApi {
    @GET("search/shows")
    suspend fun multiSearch(
        @Query("q") query: String,
    ): List<SearchResponse>
}
