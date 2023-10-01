package com.example.eberryassignmentbyparisa.domain.model

data class SearchState(
    val isLoading:Boolean=false,
    val data:List<SearchResponse> = emptyList(),
    val error:String=""
)