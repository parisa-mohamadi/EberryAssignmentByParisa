package com.example.eberryassignmentbyparisa.domain.repository

import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.util.Resource

interface RemoteDataSource {
    suspend fun multiSearch(query: String): Resource<List<SearchResponse>>
}