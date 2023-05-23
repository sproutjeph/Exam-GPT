package com.mbahjephthah.examgpt.features.exams.presentation.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExamYearButton(
    modifier: Modifier = Modifier,
    year: String,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Text(
            text = year,
            modifier = modifier
        )

    }

}

@Preview
@Composable
fun ExamYearButtonPreview() {

    ExamYearButton(
        year = "2010",
        onClick = {}
    )
}