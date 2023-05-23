package com.mbahjephthah.examgpt.features.exams.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExamTabContent(
    modifier: Modifier = Modifier,
    title: String,
    subjects: List<String>,
    onExamSubjectClicked: (String) -> Unit
) {


    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.titleMedium.fontSize

        )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp),
                modifier = Modifier,
                contentPadding = PaddingValues(
                    horizontal = 12.dp,
                    vertical = 8.dp
                ),
                content = {
                    items(subjects) {
                        SubjectButton(
                            subject = it,
                            onClick = { onExamSubjectClicked(it) },
                            modifier = Modifier
                                .padding(2.dp)

                        )
                    }

                }
            )


    }


}

@Preview(showBackground = true)
@Composable
fun ExamTabContentPreview() {
    ExamTabContent(
        title = "UTME PAST QUESTIONS",
        subjects = listOf(
            "ENGLISH",
            "CHEMISTRY",
            "MATHEMATICS",
            "ANIMALS",
            "SCIENTISTS",
            "TECHNOLOGY",
            "MEDICINE",
            "EDUCATION",
        ),
        onExamSubjectClicked = {}
    )
}