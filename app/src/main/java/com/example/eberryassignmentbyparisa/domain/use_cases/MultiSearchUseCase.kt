package com.example.eberryassignmentbyparisa.domain.use_cases

import com.example.eberryassignmentbyparisa.data.repository.Repository
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.util.Resource

class MultiSearchUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(query: String): Resource<List<SearchResponse>> {
        return repository.multiSearch(query = query)
    }
}