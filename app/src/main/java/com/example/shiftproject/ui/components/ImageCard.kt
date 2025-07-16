package com.example.shiftproject.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.shiftproject.R

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    pictureUrl: String,
    shape: Shape,
) {
    Card(
        modifier = modifier,
        shape = shape,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(pictureUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
    }
}
