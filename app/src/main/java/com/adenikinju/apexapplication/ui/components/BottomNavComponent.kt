package com.adenikinju.apexapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.adenikinju.apexapplication.R

@Composable
fun BottomNavComponent(
    bottomNavItems: List<BottomNavItem>,
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination
    BottomNavigation(
        elevation = 180.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .height(60.dp)
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)),
    ) {

        bottomNavItems.forEach { it ->
            val isSelected = destination?.route == it.route
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(id = navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Image(
                        painter = painterResource(it.selectedIcon),
                        contentDescription = it.contentDescription,
                        modifier = Modifier.size(20.dp),
                    )
                },
                label = { Text(text = it.name, fontSize = 9.sp) },
                selectedContentColor = colorResource(R.color.nav_Selected_color),
                unselectedContentColor = colorResource(R.color.nav_Unselected_color)
            )
        }
    }
}


data class BottomNavItem(
    val route: String,
    val name: String,
    val selectedIcon: Int,
    val contentDescription: String
)