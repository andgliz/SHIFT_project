package com.example.shiftproject.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shiftproject.data.model.User
import com.example.shiftproject.ui.ShiftTopBar

@Composable
fun UserCard(
    user: User,
    modifier: Modifier = Modifier,
    onIconButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            ShiftTopBar(
                title = "User Info",
                icon = Icons.Filled.Close,
                onIconButtonClick = onIconButtonClick,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            ImageCard(
                modifier = Modifier
                    .aspectRatio(1f),
                pictureUrl = user.pictureUrl,
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
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
