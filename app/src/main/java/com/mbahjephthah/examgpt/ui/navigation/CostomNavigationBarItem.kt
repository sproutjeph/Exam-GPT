package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.util.Locale

class CostomNavigationBarItem(
    val selected: Boolean,
    val onClicked: () -> Unit,
    val icon: @Composable () -> Unit,
    val label: @Composable () -> Unit
) {
    companion object {
        fun buildNavigationItems(
            currentDestination: Destination,
            onNavigate:(destination: Destination) -> Unit
        ): List<CostomNavigationBarItem> {
            return listOf(
                Destination.Home,
                Destination.Exams,
                Destination.Profile,
                Destination.Books,
                Destination.Ai
            ).map {
                CostomNavigationBarItem(
                    selected = currentDestination.path == it.path,
                    onClicked = {onNavigate(it)},
                    icon = {
                        it.icon?.let { icon ->
                            Icon(
                                imageVector = icon,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text( text = it.path.replaceFirstChar { char ->
                            char.titlecase(Locale.getDefault())
                        },)
                    }
                )
            }

        }
    }
}