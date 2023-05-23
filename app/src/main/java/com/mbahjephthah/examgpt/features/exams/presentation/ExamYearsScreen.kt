package com.mbahjephthah.examgpt.features.exams.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbahjephthah.examgpt.features.exams.presentation.components.ExamYearButton



@Composable
fun ExamYearsScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onExamYearClicked: (String) -> Unit
) {
    val examYears = listOf(
        "2000", "2001", "2002", "2003", "2004", "2005",
        "2006", "2007", "2008", "2009", "2010", "2011", 
        "2012", "2013", "2014", "2015", "2016", "2017", 
        "2018", "2019", "2020", "2021", "2022", "2023",
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "WASSCE ENGLISH",
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.titleMedium.fontSize
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(80.dp),
            modifier = Modifier
                .weight(0.5f),
            content = {

                items(examYears){examYear->
                    ExamYearButton(
                        modifier= Modifier.padding(2.dp),
                        year = examYear,
                        onClick = { onExamYearClicked(examYear) }
                    )

                }

            }
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewExamYearsScreen() {
    ExamYearsScreen(
        onExamYearClicked = {},
        onBackClicked = {}
    )
}