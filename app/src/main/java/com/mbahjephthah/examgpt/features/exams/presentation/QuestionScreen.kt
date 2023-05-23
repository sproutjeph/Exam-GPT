package com.mbahjephthah.examgpt.features.exams.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbahjephthah.examgpt.features.exams.domain.model.QuestionOptions
import com.mbahjephthah.examgpt.features.exams.presentation.components.QuestionCard
import com.mbahjephthah.examgpt.ui.theme.ExamGptTheme

@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    onAskAiClicked: (String) -> Unit
) {
    val sampleQuestion =
        "If the distance covered by a body in time t seconds is s = t2 - 6t2  - 5t, what is its initial velocity?"


    val sampleOptions = QuestionOptions(
        a = "0ms-1",
        b = "-4 ms-1 ",
        c = "(13t2  - 12t + 5) ms-1",
        d = "5ms-1 ",
        e = "5ms-1 "
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            text = "2022 WASSCE Mathematics Questions",
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )

        LazyColumn(){
            item {
                QuestionCard(
                    onAskAiClicked = onAskAiClicked
                )
            }
            item {
                QuestionCard(
                    onAskAiClicked = onAskAiClicked
                )
            }
            item {
                QuestionCard(
                    onAskAiClicked = onAskAiClicked
                )
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun QuestionScreenPreview() {
    ExamGptTheme {
        QuestionScreen(
            onAskAiClicked = {}
        )

    }

}