package com.example.eberryassignmentbyparisa.domain.repository

import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.model.Show
import com.example.eberryassignmentbyparisa.domain.util.Resource

interface RemoteDataSource {

    suspend fun getTVShows(): Resource<List<Show>>

    suspend fun multiSearch(query: String): Resource<List<SearchResponse>>
}