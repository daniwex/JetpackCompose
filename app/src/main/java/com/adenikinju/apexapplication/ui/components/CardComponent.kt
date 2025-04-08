package com.adenikinju.apexapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adenikinju.apexapplication.R


@Composable
fun CardComponent(
    header: Int,
    body: Int,
    backgroundImg: Int? = null,
    backgroundColor: List<Int>,
    textColor: Int
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .height(150.dp)
            .width(340.dp)
            .background(
                Brush.linearGradient(
                    colors = backgroundColor.map {
                        colorResource(it)
                    }.toList(),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        backgroundImg?.let { painterResource(it) }?.let {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = it,
                    contentDescription = "background image",
                    modifier = Modifier.size(180.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(header),
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                color = colorResource(textColor)
            )
            Text(
                text = stringResource(body),
                fontWeight = FontWeight.Light,
                fontSize = 15.sp,
                color = colorResource(textColor)
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(topStart = 40.dp))
                .background(Color.White)
                .size(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.right_arrow_1),
                contentDescription = "right arrow",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}