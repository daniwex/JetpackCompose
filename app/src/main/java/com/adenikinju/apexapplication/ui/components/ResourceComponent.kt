package com.adenikinju.apexapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ResourceComponent(
    icon: @Composable () -> Unit,
    title: String
) {
    Column(
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                clip = false,
                shape = RoundedCornerShape(1.dp),
                spotColor = Color(0,0,0,100)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .size(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()
        Spacer(Modifier.height(10.dp))
        Text(title)
    }
}