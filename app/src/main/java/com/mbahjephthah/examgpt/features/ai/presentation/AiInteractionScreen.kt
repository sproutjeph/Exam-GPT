package com.mbahjephthah.examgpt.features.ai.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbahjephthah.examgpt.ui.theme.ExamGptTheme

@SuppressLint("SuspiciousIndentation")
@Composable
fun AiInteractionScreen(
    modifier: Modifier = Modifier,
    question: String ="If the distance covered by a body in time t seconds is s = t2 - 6t2  - 5t, what is its initial velocity?"
) {
    val scrollState = rememberScrollState()
    val answer = "The initial velocity is the velocity of the body at time t = 0. The velocity of the body is given by the derivative of the distance function, which is v = 2t - 12t + 5. At time t = 0, the velocity is v = 2(0) - 12(0) + 5 = 5 m/s. Therefore, the initial velocity of the body is 5 m/s.\n" +
            "\n" +
            "Here is the solution in detail:\n" +
            "\n" +
            "The distance covered by the body is given by the equation s = t^2 - 6t^2 + 5t.\n" +
            "\n" +
            "The velocity of the body is the rate of change of the distance, which is given by the derivative of the distance function. The derivative of s = t^2 - 6t^2 + 5t is v = 2t - 12t + 5.\n" +
            "\n" +
            "The initial velocity is the velocity of the body at time t = 0. At time t = 0, the velocity is v = 2(0) - 12(0) + 5 = 5 m/s.\n" +
            "\n" +
            "Therefore, the initial velocity of the body is 5 m/s."


        Column(
            modifier = modifier
                .padding(16.dp)
                .verticalScroll(state = scrollState)
        ) {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer

                )

            ) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = question
                )

            }
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer

                )

            ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = answer
                )

            }
            Spacer(modifier = Modifier.height(16.dp))




        }











}

@Preview(showBackground = true)
@Composable
fun AiInteractionScreenPreview() {

    ExamGptTheme {
        AiInteractionScreen()

    }

}