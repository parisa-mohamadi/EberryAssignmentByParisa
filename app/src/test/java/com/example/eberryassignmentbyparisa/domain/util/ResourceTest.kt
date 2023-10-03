package com.example.eberryassignmentbyparisa.domain.util

import org.junit.Assert.assertEquals
import org.junit.Test

class ResourceTest {

    @Test
    fun successResource() {
        val data = "SuccessData"
        val successResource = Resource.Success(data)

        assertEquals(data, successResource.data)
        assertEquals(null, successResource.message)
    }

    @Test
    fun errorResource() {
        val errorMessage = "Error message"
        val errorData = "ErrorData"
        val errorResource = Resource.Error(errorMessage, errorData)

        assertEquals(errorData, errorResource.data)
        assertEquals(errorMessage, errorResource.message)
    }

    @Test
    fun loadingResource() {
        val data = "LoadingData"
        val loadingResource = Resource.Loading(data)

        assertEquals(data, loadingResource.data)
        assertEquals(null, loadingResource.message)
    }
}
