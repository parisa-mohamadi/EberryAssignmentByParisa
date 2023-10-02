package com.example.eberryassignmentbyparisa.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResponse(
    @SerializedName("score") val score: Double,
    @SerializedName("show") val show: Show,
):Parcelable

@Parcelize
data class Show(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: Image,
    @SerializedName("type")val type: String,
    @SerializedName("language")val language: String,
    @SerializedName("genres")val genres: List<String>,
    @SerializedName("rating")val rating: Rating,
    @SerializedName("summary")val summary: String,
):Parcelable

@Parcelize
data class Image(
    @SerializedName("medium") val medium: String,
    @SerializedName("original") val original: String,
):Parcelable

@Parcelize
data class Rating(
    @SerializedName("average")val average: Double
):Parcelable
