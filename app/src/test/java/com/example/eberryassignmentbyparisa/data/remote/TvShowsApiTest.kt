package com.example.eberryassignmentbyparisa.data.remote

import com.example.eberryassignmentbyparisa.domain.model.Image
import com.example.eberryassignmentbyparisa.domain.model.Rating
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.domain.model.Show
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class TvShowsApiTest {

    @Mock
    private lateinit var tvShowsApi: TvShowsApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testMultiSearch() = runBlocking {
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

        val response = tvShowsApi.multiSearch(query)

        assertEquals(mockResponse, response)
    }
}
