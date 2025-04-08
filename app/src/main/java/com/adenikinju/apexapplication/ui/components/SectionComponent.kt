package com.adenikinju.apexapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun SectionComponent(
    headerSection: @Composable () -> Unit,
    body: @Composable () -> Unit
){

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        headerSection()
        body()
    }

}
