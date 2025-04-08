package com.adenikinju.apexapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.adenikinju.apexapplication.ui.components.AppNavigation
import com.adenikinju.apexapplication.ui.components.BottomNavComponent
import com.adenikinju.apexapplication.ui.theme.ApexApplicationTheme
import com.adenikinju.apexapplication.ui.viewmodel.CourseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApexApplicationTheme {
                val navController = rememberNavController()
                val courseViewModel: CourseViewModel = viewModel()

                val listOfBottomNavItem by courseViewModel.bottomNavItems.observeAsState(emptyList())

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.navigationBars.asPaddingValues()),
                    bottomBar = {
                        BottomNavComponent(
                            navController = navController,
                            bottomNavItems = listOfBottomNavItem // No longer needs lateinit!
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                    ) {
                        AppNavigation(
                            navHostController = navController,
                            courseViewModel = courseViewModel
                        )
                    }
                }
            }
        }
    }
}


