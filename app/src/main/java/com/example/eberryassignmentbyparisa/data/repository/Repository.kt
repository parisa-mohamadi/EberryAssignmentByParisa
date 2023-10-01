package com.example.eberryassignmentbyparisa.data.repository

import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.model.TvShowsDetails
import com.example.eberryassignmentbyparisa.domain.repository.RemoteDataSource
import com.example.eberryassignmentbyparisa.domain.util.Resource

import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
) {

    suspend fun getTVShows(): Resource<TvShowsDetails> {
        return remote.getTVShows()
    }

    suspend fun multiSearch(query: String): Resource<List<SearchResponse>> {
        return remote.multiSearch(query = query)
    }

}