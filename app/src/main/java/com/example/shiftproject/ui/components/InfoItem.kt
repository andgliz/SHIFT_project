package com.example.shiftproject.ui.components

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun InfoItem(
    icon: ImageVector,
    info: String,
    itemName: String,
    onInfoClicked: () -> Unit,
    textDecoration: TextDecoration,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(2.1f),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp),
            )
            Text(
                text = itemName,
            )
        }
        Text(
            text = info,
            modifier = Modifier
                .weight(4f)
                .clickable { onInfoClicked() },
            textDecoration = textDecoration,
        )
    }
}
