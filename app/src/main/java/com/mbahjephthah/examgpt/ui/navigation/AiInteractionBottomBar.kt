package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AiInteractionBottomBar(
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            placeholder = {
                Text(
                    text = "Enter your question here",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            },
            colors = TextFieldDefaults.colors()

        )

    }

}