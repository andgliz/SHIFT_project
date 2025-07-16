package com.example.shiftproject.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShiftTopBar(
    title: String,
    icon: ImageVector,
    onIconButtonClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        modifier = Modifier,
        navigationIcon = {
            IconButton(
                onClick = { onIconButtonClick() },
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                )
            }
        }
    )
}
