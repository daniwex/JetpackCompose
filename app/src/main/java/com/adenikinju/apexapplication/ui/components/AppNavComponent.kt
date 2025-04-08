package com.adenikinju.apexapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adenikinju.apexapplication.ui.screens.CourseScreen
import com.adenikinju.apexapplication.ui.screens.HomeScreen
import com.adenikinju.apexapplication.ui.screens.NotificationScreen
import com.adenikinju.apexapplication.ui.screens.ProfileScreen
import com.adenikinju.apexapplication.ui.screens.SupportScreen
import com.adenikinju.apexapplication.ui.viewmodel.CourseViewModel

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    courseViewModel: CourseViewModel
) {

    NavHost(startDestination = Screens.HOME.name, navController = navHostController) {

        composable(Screens.HOME.name) {
            HomeScreen(courseViewModel)
        }
        composable(Screens.COURSES.name) {
            CourseScreen()
        }
        composable(Screens.SUPPORT.name) {
            SupportScreen()
        }
        composable(Screens.NOTIFICATIONS.name) {
            NotificationScreen()
        }
        composable(Screens.PROFILE.name) {
            ProfileScreen()
        }
    }
}


enum class Screens(route: String) {
    HOME("Home"), COURSES("Courses"), SUPPORT("Support"), NOTIFICATIONS("Notifications"), PROFILE("Me")
}