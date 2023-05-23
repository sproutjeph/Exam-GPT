package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mbahjephthah.examgpt.R
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootDestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    openDrawer: () -> Unit,
    onSettingsDialogOpen:()->Unit
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = currentDestination.path.uppercase(Locale.ROOT),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = { openDrawer.invoke() }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            if (currentDestination == Destination.Home) {
                IconButton(onClick = {onSettingsDialogOpen.invoke()}) {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = stringResource(
                            id = R.string.cd_more_information
                        ),
                        tint = MaterialTheme.colorScheme.onSurface,

                        )
                }
            }

        },
        colors = colors

    )

}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(name= "Top App BAR")
@Composable
private fun ExamGPTTopAppBarPreview() {
    RootDestinationTopBar(
        openDrawer = {},
        currentDestination = Destination.Home,
        onSettingsDialogOpen = {}
    )

}