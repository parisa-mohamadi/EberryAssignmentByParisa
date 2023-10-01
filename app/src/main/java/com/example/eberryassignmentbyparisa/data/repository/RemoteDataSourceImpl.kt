package com.example.eberryassignmentbyparisa.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eberryassignmentbyparisa.data.remote.TvShowsApi
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.model.TvShowsDetails
import com.example.eberryassignmentbyparisa.domain.repository.RemoteDataSource
import com.example.eberryassignmentbyparisa.domain.util.Resource
import javax.inject.Inject

/**
 * TvShowsRepositoryImpl is an implementation of the TvShowsRepository interface,
 * responsible for retrieving data from an external API.
 * @param api The WeatherApi instance used for making API requests.
 */

class RemoteDataSourceImpl @Inject constructor(
    private val api: TvShowsApi
): RemoteDataSource {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getTVShows(): Resource<TvShowsDetails> {
        return try {
            Resource.Success(
                data = api.getTVShows()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun multiSearch(q:String):Resource<List<SearchResponse>>{
        return  try{
            val result = api.multiSearch(query = q)
            Resource.Success(data = result)
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

}