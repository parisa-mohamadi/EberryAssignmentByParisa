package com.example.eberryassignmentbyparisa.presentation.tvShowsdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.eberryassignmentbyparisa.domain.model.Image
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsDetailsScreen(
//    tvShowName: String,
//    tvShowImage: String,
//    tvShowLanguage: String,
//    tvShowGenres: List<String>,
//    tvShowRating: Rating,
//    tvShowSummary: String,
    tvShowResponse: SearchResponse,
    tvShowsDetailsViewModel: TvShowsDetailsViewModel = hiltViewModel(),
) {
    val result = tvShowsDetailsViewModel.searchResult.value
    Surface(modifier = Modifier.fillMaxSize()){
        if (result.data.isNotEmpty()){
            tvShowsDetailsViewModel.searchResult.value.data?.let{
                MovieImage(it[0].show.image)
                Column(modifier = Modifier.padding(32.dp)){
                    Text(text = it[0].show.name)
                    Text(text = it[0].show.name)
                    Text(text = it[0].show.name)
                }
            }
        }
    }

}

@Composable
private fun MovieImage(image: Image) {
    Card(
        Modifier
            .width(240.dp)
            .height(160.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        val request = ImageRequest.Builder(LocalContext.current)
            .data(image.medium)
            .crossfade(true)
            .build()
        val painter = rememberAsyncImagePainter(
            model = request,
        )

        Image(
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
    }
}
