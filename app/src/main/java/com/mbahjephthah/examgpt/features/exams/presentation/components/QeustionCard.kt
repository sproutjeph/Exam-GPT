package com.mbahjephthah.examgpt.features.exams.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahjephthah.examgpt.features.exams.domain.model.QuestionOptions
import com.mbahjephthah.examgpt.ui.theme.ExamGptTheme

@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    onAskAiClicked: (String) -> Unit,
    question: String =  "If the distance covered by a body in time t seconds is s = t2 - 6t2  - 5t, what is its initial velocity?",
    options: QuestionOptions = QuestionOptions(
        a = "0ms-1",
        b = "-4 ms-1 ",
        c = "(13t2  - 12t + 5) ms-1",
        d = "5ms-1 ",
        e = "5ms-1 "
    ),

) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier
                .width(25.dp)
                .height(25.dp)
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.inversePrimary,
            shape = RoundedCornerShape(50)
        ) {
                Text(
                    text = "1",
                    textAlign = TextAlign.Center
                )
        }



        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            Text(
                text = question,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 4.dp),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 1.sp,
                    lineHeight = 20.sp
                )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "OPTIONS",
                textAlign = TextAlign.Center
            )

            LazyRow(
                modifier = Modifier,
                contentPadding = PaddingValues(horizontal = 12.dp)

            ) {
                items(QuestionOptions.toList(options)) { option ->
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape = MaterialTheme.shapes.extraSmall,
                        modifier = Modifier
                            .padding(4.dp),
                        contentPadding = PaddingValues(
                            horizontal = 8.dp,
                            vertical = 8.dp
                        )

                    ) {
                        Text(text = option)

                    }


                }


            }

            TextButton(
                onClick = { onAskAiClicked(question) },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text(text = "Ask AI To Solve")
            }


        }
    }

}



@Preview(showBackground = true)
@Composable
fun QuestionCardPreview() {
    ExamGptTheme {
    QuestionCard(
        onAskAiClicked = {}
    )
    }

}