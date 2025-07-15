package com.example.shiftproject.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.shiftproject.R
import com.example.shiftproject.data.model.User
import com.example.shiftproject.ui.ShiftTopBar

@Composable
fun UsersScreen(
    modifier: Modifier = Modifier,
    userList: List<User>,
    onUserCardClick: (userName: String, userLastName: String) -> Unit,
    onIconButtonClick: () -> Unit
) {
    Scaffold(
        topBar = {
            ShiftTopBar(
                title = "Users",
                icon = Icons.Filled.Refresh,
                onIconButtonClick = onIconButtonClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp),
        ) {
            items(userList) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(136.dp)
                        .padding(bottom = 8.dp),
                ) {
                    TextButton(
                        onClick = { onUserCardClick(user.name, user.lastName) },
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            ImageCard(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .aspectRatio(1f),
                                pictureUrl = user.pictureUrl,
                            )
                            Column(
                                modifier = Modifier.padding(start = 16.dp),
                            ) {
                                Text(
                                    text = "${user.name} ${user.lastName}",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = user.phoneNumber,
                                )
                                Text(
                                    text = user.location,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    pictureUrl: String,
) {
    Card(
        modifier = modifier,
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
