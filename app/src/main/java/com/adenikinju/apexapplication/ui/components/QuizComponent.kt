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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material3.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizComponent(
    header: Int,
    backgroundImg: Int? = null,
    backgroundColor: Int,
    textColor: Int,
    isComplete: Boolean,
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .height(100.dp)
            .width(200.dp)
            .background(color =  colorResource(backgroundColor))
    ) {
        backgroundImg?.let { painterResource(it) }?.let {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = it,
                    contentDescription = "background image",
                    modifier = Modifier.size(90.dp),
                    tint = Color(255,255,255,100)
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = isComplete,
                    onClick = {
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                )
                Text(
                    text = "${if (isComplete) "Completed" else "Incomplete"}",
                    color = colorResource(textColor),
                    fontSize = 19.sp
                )
            }
        }
    }
}

