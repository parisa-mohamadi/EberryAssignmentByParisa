package com.example.eberryassignmentbyparisa.domain.repository

import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.model.TvShowsDetails
import com.example.eberryassignmentbyparisa.domain.util.Resource

interface RemoteDataSource {

    suspend fun getTVShows(): Resource<TvShowsDetails>

    suspend fun multiSearch(query: String): Resource<List<SearchResponse>>
}