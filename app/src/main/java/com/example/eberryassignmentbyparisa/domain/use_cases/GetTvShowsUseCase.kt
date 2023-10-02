package com.example.eberryassignmentbyparisa.domain.use_cases

import com.example.eberryassignmentbyparisa.data.repository.Repository
import com.example.eberryassignmentbyparisa.domain.model.Show
import com.example.eberryassignmentbyparisa.domain.util.Resource


class GetTvShowsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Resource<Show> {
        return repository.getTVShows()
    }
}