package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildDestinationTopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    title: String
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title.uppercase(),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = { onNavigateUp.invoke() }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.cd_navigate_up),
                    tint = MaterialTheme.colorScheme.onSurface,

                    )
            }
        },
        colors = colors
    )


}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(name= "Top App BAR")
@Composable
private fun ExamGPTTopAppBarPreview() {
    ChildDestinationTopBar(
        onNavigateUp = {},
        title = "Top Appbar"
    )

}