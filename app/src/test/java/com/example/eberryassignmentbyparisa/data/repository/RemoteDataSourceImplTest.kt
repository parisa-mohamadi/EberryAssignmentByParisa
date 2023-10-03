package com.example.eberryassignmentbyparisa.data.repository

import com.example.eberryassignmentbyparisa.data.remote.TvShowsApi
import com.example.eberryassignmentbyparisa.domain.model.Image
import com.example.eberryassignmentbyparisa.domain.model.Rating
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.model.Show
import com.example.eberryassignmentbyparisa.domain.repository.RemoteDataSource
import com.example.eberryassignmentbyparisa.domain.util.Resource
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RemoteDataSourceImplTest {

    @Mock
    private lateinit var tvShowsApi: TvShowsApi

    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        remoteDataSource = RemoteDataSourceImpl(tvShowsApi)
    }

    @Test
    fun testMultiSearchSuccess() = runBlocking {
        val query = "test_query"

        val mockResponse = listOf(
            SearchResponse(
                score = 0.6991597,
                show = Show(
                    id = 38339,
                    name = "A Teacher",
                    image = Image(
                        medium = "https://static.tvmaze.com/uploads/images/medium_portrait/272/681431.jpg",
                        original = "https://static.tvmaze.com/uploads/images/original_untouched/272/681431.jpg"
                    ),
                    type = "Scripted",
                    language = "English",
                    genres = listOf("Drama"),
                    rating = Rating(average = 5.8),
                    summary = "<p><b>A Teacher</b> examines the complexities and consequences of an illegal relationship between a female teacher"
                )
            )
        )

        `when`(tvShowsApi.multiSearch(query)).thenReturn(mockResponse)

        val result = remoteDataSource.multiSearch(query)

        assertThat(result, instanceOf(Resource.Success::class.java))
        assertEquals(mockResponse, result.data)
    }

    @Test
    fun testMultiSearchError() = runBlocking {
        val query = "test_query"

        val mockException = RuntimeException("Test exception")
        val expectedErrorMessage = mockException.message.toString()

        `when`(tvShowsApi.multiSearch(query)).thenThrow(mockException)

        val result = remoteDataSource.multiSearch(query)

        assertThat(result, instanceOf(Resource.Error::class.java))
        assertEquals(expectedErrorMessage, result.message)
    }
}
