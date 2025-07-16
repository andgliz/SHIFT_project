package com.example.shiftproject.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.shiftproject.domain.User
import com.example.shiftproject.ui.components.ShiftTopBar
import com.example.shiftproject.ui.components.ImageCard
import com.example.shiftproject.ui.components.InfoItem
import com.example.shiftproject.ui.components.UserMainInfo

@Composable
fun UserScreen(
    user: User,
    modifier: Modifier = Modifier,
    onIconButtonClick: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            ShiftTopBar(
                title = "User Info",
                icon = Icons.Filled.Close,
                onIconButtonClick = onIconButtonClick,
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            Column {
                Spacer(
                    modifier = Modifier.height(72.dp),
                )
                Card(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Spacer(
                        modifier = Modifier.height(72.dp),
                    )
                    Column(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        UserMainInfo(
                            userName = "${user.name} ${user.lastName}",
                            modifier = Modifier,
                            horizontal = Alignment.CenterHorizontally,
                            firstInfoField = "${user.gender}, ${user.age} years old",
                            secondInfoField = "Nationality: ${user.nationality}",
                        )
                        HorizontalDivider(
                            thickness = 1.dp,
                            modifier = Modifier.padding(16.dp),
                        )
                        InfoItem(
                            icon = Icons.Filled.Call,
                            info = user.phoneNumber,
                            itemName = "Phone:",
                            onInfoClicked = { uriHandler.openUri("tel:${user.phoneNumber}") },
                            textDecoration = TextDecoration.Underline,
                        )
                        InfoItem(
                            icon = Icons.Filled.Email,
                            info = user.email,
                            itemName = "Email:",
                            onInfoClicked = { uriHandler.openUri("mailto:${user.email}") },
                            textDecoration = TextDecoration.Underline,
                        )
                        InfoItem(
                            icon = Icons.Filled.DateRange,
                            info = user.date,
                            itemName = "DOB:",
                            onInfoClicked = { },
                            textDecoration = TextDecoration.None,
                        )
                        InfoItem(
                            icon = Icons.Filled.Home,
                            info = "${user.location}, ${user.address}",
                            itemName = "Address:",
                            onInfoClicked = { uriHandler.openUri("geo:0,0?q=${Uri.encode("${user.location}, ${user.address}")}") },
                            textDecoration = TextDecoration.Underline,
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
            ) {
                ImageCard(
                    modifier = Modifier
                        .width(144.dp)
                        .aspectRatio(1f),
                    pictureUrl = user.pictureUrl,
                    shape = CircleShape,
                )
            }
        }
    }
}
