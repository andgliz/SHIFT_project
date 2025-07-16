package com.example.shiftproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserMainInfo(
    userName: String,
    modifier: Modifier = Modifier,
    horizontal: Alignment.Horizontal,
    firstInfoField: String,
    secondInfoField: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontal,
    ) {
        Text(
            text = userName,
            fontSize = 20.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier.padding(bottom = 12.dp),
        )
        Text(
            text = firstInfoField,
        )
        Text(
            text = secondInfoField,
        )
    }
}
