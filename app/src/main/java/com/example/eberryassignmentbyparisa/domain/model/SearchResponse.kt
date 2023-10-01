package com.example.eberryassignmentbyparisa.domain.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("score") val score: Double,
    @SerializedName("show") val show: Show,
)

data class Show(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: Image, val type: String,
    @SerializedName("language")val language: String,
    @SerializedName("genres")val genres: List<String>,
    @SerializedName("rating")val rating: Rating,
    @SerializedName("summary")val summary: String,
)

data class Image(
    @SerializedName("medium") val medium: String,
    @SerializedName("original") val original: String,
)

data class Rating(
    @SerializedName("average")val average: Double
)
