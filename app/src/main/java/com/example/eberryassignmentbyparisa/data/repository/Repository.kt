package com.example.eberryassignmentbyparisa.data.repository

import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.repository.RemoteDataSource
import com.example.eberryassignmentbyparisa.domain.util.Resource
import javax.inject.Inject

/**
 * Repository class responsible for fetching search results.
 * @param remote The remote data source to retrieve data from.
 */

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
) {

    suspend fun multiSearch(query: String): Resource<List<SearchResponse>> {
        return remote.multiSearch(query = query)
    }

}