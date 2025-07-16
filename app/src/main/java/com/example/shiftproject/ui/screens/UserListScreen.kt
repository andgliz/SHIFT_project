package com.example.shiftproject.ui.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shiftproject.domain.User
import com.example.shiftproject.ui.components.ShiftTopBar
import com.example.shiftproject.ui.components.ImageCard
import com.example.shiftproject.ui.components.UserMainInfo

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    userList: List<User>,
    onUserCardClick: (userName: String, userLastName: String) -> Unit,
    onIconButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            ShiftTopBar(
                title = "Users",
                icon = Icons.Filled.Refresh,
                onIconButtonClick = onIconButtonClick,
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
        ) {
            items(userList) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(136.dp)
                        .padding(bottom = 16.dp),
                    onClick = { onUserCardClick(user.name, user.lastName) },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                    ) {
                        ImageCard(
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(1f),
                            pictureUrl = user.pictureUrl,
                            shape = CardDefaults.shape,
                        )
                        UserMainInfo(
                            userName = "${user.name} ${user.lastName}",
                            modifier = Modifier.padding(start = 16.dp),
                            horizontal = Alignment.Start,
                            firstInfoField = user.phoneNumber,
                            secondInfoField = user.location,
                        )
                    }
                }
            }
        }
    }
}
