package com.mbahjephthah.examgpt.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.mbahjephthah.examgpt.features.exams.presentation.ExamYearsScreen
import com.mbahjephthah.examgpt.features.settings_dialog.presentation.SettingsDialog
import com.mbahjephthah.examgpt.ui.navigation.AiInteractionBottomBar
import com.mbahjephthah.examgpt.ui.navigation.BottomNavBar
import com.mbahjephthah.examgpt.ui.navigation.Destination
import com.mbahjephthah.examgpt.ui.navigation.DestinationTopBar
import com.mbahjephthah.examgpt.ui.navigation.NavDrawer
import com.mbahjephthah.examgpt.ui.navigation.Navigation
import com.mbahjephthah.examgpt.ui.navigation.RailNavigationBar
import com.mbahjephthah.examgpt.ui.theme.ExamGptBackground
import kotlinx.coroutines.launch


@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    widthSizeClass: WindowWidthSizeClass,
    onNavigationSelected: (destination: Destination) -> Unit,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit,
    onNavigateUp: () -> Unit,
    drawerState: DrawerState,
    startDestination: String,
    navController: NavHostController

) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var showSettingsDialog by remember {
        mutableStateOf(false)
    }

    if (showSettingsDialog) {
        SettingsDialog {
            showSettingsDialog = false
        }
    }

    ExamGptBackground {


        NavDrawer(
            modifier = modifier,
            drawerState = drawerState,
            onNavigationSelected = onNavigationSelected,
            onLogout = { /*TODO*/ }) {


            Scaffold(
                modifier = Modifier,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                snackbarHost = { SnackbarHost(snackbarHostState) },
                topBar = {
                    DestinationTopBar(
                        destination = currentDestination,
                        onNavigateUp = onNavigateUp,
                        onOpenDrawer = {
                            scope.launch {
                                drawerState.open()
                            }
                        },
                        onSettingsDialogOpen = { showSettingsDialog = true }

                    )
                },
                bottomBar = {
                    if (widthSizeClass == WindowWidthSizeClass.Compact && currentDestination.path != Destination.Ai.path) {
                        BottomNavBar(
                            currentDestination = currentDestination,
                            onNavigate = onNavigate
                        )


                    }else{
                        AiInteractionBottomBar()
                    }
                }
            ) { paddingValues ->

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    if (widthSizeClass != WindowWidthSizeClass.Compact) {
                        RailNavigationBar(
                            currentDestination = currentDestination,
                            onNavigate = onNavigate
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Navigation(
                            modifier = Modifier,
                            startDestination = startDestination,
                            navController = navController,
                        )


                    }
                }


            }

        }
    }

}