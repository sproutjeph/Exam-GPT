package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mbahjephthah.examgpt.ui.navigation.CostomNavigationBarItem.Companion.buildNavigationItems

@Composable
fun RailNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate:(destination: Destination) -> Unit,
) {


    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = AppNavigationDefaults.navigationContentColor()

    ) {
        buildNavigationItems(
            currentDestination = currentDestination,
            onNavigate = onNavigate

        ).forEach { destination->
            NavigationRailItem(
                selected = destination.selected,
                onClick = destination.onClicked,
                icon = destination.icon,
                label = destination.label,
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = AppNavigationDefaults.navigationSelectedItemColor(),
                    unselectedIconColor = AppNavigationDefaults.navigationContentColor(),
                    selectedTextColor = AppNavigationDefaults.navigationSelectedItemColor(),
                    unselectedTextColor = AppNavigationDefaults.navigationContentColor(),
                    indicatorColor = AppNavigationDefaults.navigationIndicatorColor()

                )
            )


        }
    }



}

/**
 *  App navigation default values.
 */

object AppNavigationDefaults{
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}



@Preview
@Composable
fun RailNavigationBarPreview() {
    RailNavigationBar(
        currentDestination = Destination.Home,
        onNavigate = {}
    )
}