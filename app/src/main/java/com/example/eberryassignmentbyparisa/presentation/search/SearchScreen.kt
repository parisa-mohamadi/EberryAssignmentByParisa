package com.example.eberryassignmentbyparisa.presentation.search

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.eberryassignmentbyparisa.R
import com.example.eberryassignmentbyparisa.domain.model.SearchResponse
import com.example.eberryassignmentbyparisa.presentation.tvShowsdetails.TvShowsDetailsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
) {

    val query: MutableState<String> = remember { mutableStateOf("") }
    val result = searchViewModel.searchResult.value
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(8.dp)) {
            Log.d("parisa", query.value)
            OutlinedTextField(
                value = query.value, onValueChange = {
                    query.value = it
                    searchViewModel.searchAll(query.value)
                        .also { Log.d("parisa", "while passing: ${query.value}") }

                }, enabled = true,
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                label = { Text(text = "Search here...") },
                modifier = Modifier.fillMaxWidth()
            )
            if (result.isLoading) {
                Log.d("TAG", "MainContent: in the loading")
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            if (result.error.isNotBlank()) {
                Log.d("TAG", "MainContent: ${result.error}")
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = searchViewModel.searchResult.value.error
                    )
                }
            }
            if (result.data.isNotEmpty()) {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    searchViewModel.searchResult.value.data?.let {
                        items(it) {
                            MainContentItem(it){ clickedItem ->
                                Log.d("parisa", "itemclicked:${it.show.genres}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContentItem(hit: SearchResponse, onItemClick: (SearchResponse) -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onItemClick(hit) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = hit.show.name,
                fontSize = 16.sp,
                color = Color.Black,
            )
            if (hit.show.image != null) {
                Image(
                    painter = rememberAsyncImagePainter(model = hit.show.image.medium),
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
}
