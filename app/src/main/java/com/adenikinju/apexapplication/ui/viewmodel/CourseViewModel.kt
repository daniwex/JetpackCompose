package com.adenikinju.apexapplication.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adenikinju.apexapplication.R
import com.adenikinju.apexapplication.data.active.User
import com.adenikinju.apexapplication.ui.components.BottomNavItem
import com.adenikinju.apexapplication.ui.components.Screens
import com.adenikinju.apexapplication.ui.screens.EnrollmentItem
import com.adenikinju.apexapplication.ui.screens.QuizItem
import com.adenikinju.apexapplication.ui.screens.Resource

class CourseViewModel : ViewModel() {

    private val _resourceData = MutableLiveData(
        listOf(
            Resource(icon = R.drawable.campus, title = "Campus"),
            Resource(icon = R.drawable.finance, title = "Finance"),
            Resource(icon = R.drawable.community, title = "Community"),
            Resource(icon = R.drawable.library, title = "Library"),
            Resource(icon = R.drawable.calendar, title = "Calendar"),
            Resource(icon = R.drawable.sbl, title = "SBL"),
            Resource(icon = R.drawable.star, title = "Grades"),
            Resource(icon = R.drawable.academics, title = "Academics"),
        )
    )

    val resourceData = _resourceData

    private val _bottomNavItems = MutableLiveData(
        listOf(
            BottomNavItem(
                route = Screens.HOME.name,
                name = "Home",
                selectedIcon = R.drawable.home,
                contentDescription = "home"
            ),
            BottomNavItem(
                route = Screens.COURSES.name,
                name = "Courses",
                selectedIcon = R.drawable.courses,
                contentDescription = "courses"
            ),
            BottomNavItem(
                route = Screens.SUPPORT.name,
                name = "Support",
                selectedIcon = R.drawable.support,
                contentDescription = "support"
            ),
            BottomNavItem(
                route = Screens.NOTIFICATIONS.name,
                name = "Notifications",
                selectedIcon = R.drawable.bell,
                contentDescription = "notifications"
            ),
            BottomNavItem(
                route = Screens.PROFILE.name,
                name = "Me",
                selectedIcon = User.currentUser.profilePic,
                contentDescription = "profile"
            ),
        )
    )
    val bottomNavItems = _bottomNavItems

    private val _enrollmentItems = MutableLiveData(
        listOf(
            EnrollmentItem(
                header = R.string.enrollment_one_header,
                body = R.string.enrollment_one_body,
                color = R.color.red_200,
                backgroundImg = R.drawable.bg_one,
                textColor = R.color.white
            ),
            EnrollmentItem(
                header = R.string.enrollment_two_header,
                body = R.string.enrollment_two_body,
                color = R.color.light_green_50,
                endColor = R.color.light_green_300,
                textColor = R.color.light_green_100,
            ),
            EnrollmentItem(
                header = R.string.enrollment_three_header,
                body = R.string.enrollment_three_body,
                color = R.color.dark_green_200,
                backgroundImg = R.drawable.bg_three,
                textColor = R.color.white
            ),
            EnrollmentItem(
                header = R.string.enrollment_four_header,
                body = R.string.enrollment_four_body,
                color = R.color.golden_yellow,
                backgroundImg = R.drawable.bg_four,
                textColor = R.color.light_green_100
            )
        )
    )
    val enrollmentItem = _enrollmentItems

    private val _quizItems = MutableLiveData(
        listOf(
            QuizItem(
                header = R.string.quiz_item_one_header,
                color = R.color.dark_green_200,
                backgroundImg = R.drawable.jet,
                textColor = R.color.white,
                isComplete = false
            ),
            QuizItem(
                header = R.string.quiz_item_two_header,
                color = R.color.dark_green_200,
                backgroundImg = R.drawable.jet,
                textColor = R.color.white,
                isComplete = false
            ),
            QuizItem(
                header = R.string.quiz_item_three_header,
                color = R.color.dark_green_200,
                backgroundImg = R.drawable.jet,
                textColor = R.color.white,
                isComplete = false
            ),
            QuizItem(
                header = R.string.quiz_item_four_header,
                color = R.color.white,
                backgroundImg = R.drawable.jet,
                textColor = R.color.black,
                isComplete = true
            ),
            QuizItem(
                header = R.string.quiz_item_five_header,
                color = R.color.white,
                backgroundImg = R.drawable.jet,
                textColor = R.color.black,
                isComplete = true
            )
        )
    )
    val quizItem = _quizItems


}