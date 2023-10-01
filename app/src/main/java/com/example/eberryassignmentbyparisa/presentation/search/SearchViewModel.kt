package com.example.eberryassignmentbyparisa.presentation.search

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eberryassignmentbyparisa.domain.model.SearchState
import com.example.eberryassignmentbyparisa.domain.use_cases.UseCases
import com.example.eberryassignmentbyparisa.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    val searchResult: MutableState<SearchState> = mutableStateOf(SearchState())

    fun searchAll(q: String) = viewModelScope.launch {
        searchResult.value = SearchState(isLoading = true)
        try {
            val result = useCases.multiSearchUseCase(
                query = q
            )
            Log.d("parisa", result.data.toString())
            Log.d("parisa", "while getting q: ${q}")
            when (result) {
                is Resource.Error -> {
                    searchResult.value = SearchState(error = "Something went wrong")
                }
                is Resource.Success -> {
                    result.data?.let {
                        searchResult.value = SearchState(data = it)
                    }
                }
                else -> {
                    searchResult.value = SearchState(error = "not found")
                }
            }
        } catch (e: Exception) {
            searchResult.value = SearchState(error = "catch")
        }
    }
}