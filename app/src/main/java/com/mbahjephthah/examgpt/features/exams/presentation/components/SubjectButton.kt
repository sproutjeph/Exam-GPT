package com.mbahjephthah.examgpt.features.exams.presentation.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SubjectButton(
    modifier: Modifier = Modifier,
    subject: String,
    onClick: () -> Unit
) {

    TextButton(
        modifier = modifier,
        onClick =  onClick,
        colors = ButtonDefaults.buttonColors(),
        shape = MaterialTheme.shapes.small,

    ) {
        Text(
            text = subject,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }



}


@Preview(showBackground = true)
@Composable
fun PreviewSubjectButton() {
    SubjectButton(
        subject = "ENGLISH",
        onClick = {}
    )
}