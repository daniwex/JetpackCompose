package com.adenikinju.apexapplication.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adenikinju.apexapplication.R
import com.adenikinju.apexapplication.data.active.User
import com.adenikinju.apexapplication.ui.components.CardComponent
import com.adenikinju.apexapplication.ui.components.QuizComponent
import com.adenikinju.apexapplication.ui.components.ResourceComponent
import com.adenikinju.apexapplication.ui.components.SectionComponent
import com.adenikinju.apexapplication.ui.viewmodel.CourseViewModel


@Composable
fun HomeScreen(
    courseViewModel: CourseViewModel
) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    val spacing by rememberUpdatedState(if (isPortrait) 50.dp else 20.dp)

    val resourceItems by courseViewModel.resourceData.observeAsState(emptyList())
    val enrollmentItems by courseViewModel.enrollmentItem.observeAsState(emptyList())
    val quizItems by courseViewModel.quizItem.observeAsState(emptyList())



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        item {
            EnrollmentSection(enrollmentItems = enrollmentItems)
        }

        item {
            ResourceSection(sectionItems = resourceItems)
        }

        item {
            QuizSection(quizItems)
        }
    }
}


@Composable
private fun EnrollmentSection(
    enrollmentItems: List<EnrollmentItem>
) {
    SectionComponent(
        headerSection = {
            Text(
                text = "Hi, ${User.currentUser.name}",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(enrollmentItems.size) {
                val currentItem = enrollmentItems[it]
                CardComponent(
                    header = currentItem.header,
                    body = currentItem.body,
                    backgroundImg = currentItem.backgroundImg,
                    backgroundColor = listOf(currentItem.color, currentItem.endColor),
                    textColor = currentItem.textColor
                )

            }
        }
    }
}


@Composable
private fun ResourceSection(sectionItems: List<Resource>) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    val height by rememberUpdatedState(if (isPortrait) 220.dp else 120.dp)
    SectionComponent(
        headerSection = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.resources_section_header),
                    color = colorResource(R.color.dark_grey_100),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(35.dp)
                        .background(colorResource(R.color.light_grey_100)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.right_arrow),
                        contentDescription = "right arrow",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        },
        body = {
            LazyVerticalGrid(
                modifier = Modifier.height(height),
                columns = GridCells.Adaptive(minSize = 80.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(sectionItems.size) {
                    ResourceComponent(
                        icon = {
                            Icon(
                                painter = painterResource(sectionItems[it].icon),
                                contentDescription = sectionItems[it].title,
                                modifier = Modifier.size(30.dp),
                                tint = colorResource(R.color.dark_green_300)
                            )
                        },
                        title = sectionItems[it].title
                    )
                }
            }
        }
    )
}

@Composable
private fun QuizSection(
    quizItem: List<QuizItem>
) {

    SectionComponent(
        headerSection = {
            Column(
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.daily_bonus_text),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )

                    Text(
                        text = "(Week ${stringResource(R.string.current_week)})",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.clock),
                        contentDescription = "clock",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Gray
                    )
                    Text(
                        text = "${stringResource(R.string.time_left)} hours remaining",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                }
            }
        }
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(quizItem.size) {
                val currentItem = quizItem[it]

                QuizComponent(
                    header = currentItem.header,
                    backgroundImg = currentItem.backgroundImg,
                    backgroundColor = currentItem.color,
                    textColor = currentItem.textColor,
                    isComplete = currentItem.isComplete,
                )
            }
        }
    }
}

data class Resource(
    val icon: Int,
    val title: String
)


data class EnrollmentItem(
    val header: Int,
    val body: Int,
    val color: Int,
    val endColor: Int = color,
    val backgroundImg: Int? = null,
    val textColor: Int
)

data class QuizItem(
    val header: Int,
    val color: Int,
    val backgroundImg: Int? = null,
    val textColor: Int,
    val isComplete: Boolean
)