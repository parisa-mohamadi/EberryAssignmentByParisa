package com.example.eberryassignmentbyparisa.data.repository

import com.example.eberryassignmentbyparisa.data.remote.TvShowsApi
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.repository.RemoteDataSource
import com.example.eberryassignmentbyparisa.domain.util.Resource
import javax.inject.Inject

/**
 * RemoteDataSourceImpl is an implementation of the RemoteDataSource interface,
 * responsible for retrieving data from an external API.
 * @param api The TvShowsApi instance used for making API requests.
 */

class RemoteDataSourceImpl @Inject constructor(
    private val api: TvShowsApi
) : RemoteDataSource {

    override suspend fun multiSearch(query: String): Resource<List<SearchResponse>> {
        return try {
            val result = api.multiSearch(query = query)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

}