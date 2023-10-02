package com.example.eberryassignmentbyparisa.presentation.tvShowsdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.eberryassignmentbyparisa.R
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsDetailsScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    val selectedTvShow =
        navController.previousBackStackEntry?.savedStateHandle?.get<SearchResponse>("selectedTvShow")
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (selectedTvShow != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
                    .verticalScroll(state = scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieImage(selectedTvShow?.show?.image?.medium)
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    selectedTvShow?.show?.name?.let { Text(text = "Name: $it") }
                    selectedTvShow?.show?.language?.let { Text(text = "Language: $it") }
                    selectedTvShow?.show?.genres?.let { Text(text = "Genres: $it") }
                    selectedTvShow?.show?.type?.let { Text(text = "Type: $it") }
                    selectedTvShow?.show?.rating?.let { Text(text = "Rating: ${it.average}") }
                    selectedTvShow?.show?.summary?.let { Text(text = "Summary: $it") }
                }
            }
        }
    }
}

@Composable
private fun MovieImage(image: String?) {
    Card(
        Modifier
            .width(240.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        val request = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build()
        val painter = rememberAsyncImagePainter(
            model = request,
        )

        if (image != null) {
            Image(
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(5.dp))
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.image_not_available),
                contentDescription = "no image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }
}
