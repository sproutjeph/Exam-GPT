package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mbahjephthah.examgpt.ui.navigation.CostomNavigationBarItem.Companion.buildNavigationItems


@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {

    BottomAppBar(
        modifier = modifier,
    ) {
        buildNavigationItems(
            currentDestination = currentDestination,
            onNavigate = onNavigate

        ).forEach { destination->
            NavigationBarItem(
                selected = destination.selected,
                icon = destination.icon,
                label = destination.label,
                onClick = {destination.onClicked()}

            )

        }


    }

}


@Preview
@Composable
fun NavBottomBarPreview() {
    BottomNavBar(
        currentDestination = Destination.Home,
        onNavigate = {}
    )
}