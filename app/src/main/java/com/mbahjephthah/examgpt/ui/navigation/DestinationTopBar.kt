package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationTopBar(
    modifier: Modifier = Modifier,
    destination: Destination,
    onNavigateUp: ()-> Unit,
    onOpenDrawer: ()-> Unit,
    onSettingsDialogOpen: ()-> Unit = {}
) {
    if (destination.isRootDestination && destination.path == Destination.Home.path) {
        RootDestinationTopBar(
            modifier = modifier,
            currentDestination = destination,
            openDrawer = onOpenDrawer,
            onSettingsDialogOpen = onSettingsDialogOpen
        )
    } else {
        ChildDestinationTopBar(
            modifier = modifier,
            onNavigateUp = onNavigateUp,
            title = destination.path
        )
    }
}

