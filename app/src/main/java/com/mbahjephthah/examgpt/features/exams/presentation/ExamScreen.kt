package com.mbahjephthah.examgpt.features.exams.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mbahjephthah.examgpt.R
import com.mbahjephthah.examgpt.features.exams.presentation.components.ExamTabContent



@Composable
fun ExamsScreen(
    modifier: Modifier = Modifier,
    onExamSubjectClicked: (String) -> Unit,

    ) {

    val tabNames = remember {ExamTabs.values().map { it.name }}
    val selectedIndex = remember { mutableStateOf(ExamTabs.UTME.ordinal) }

    val subjects = listOf(
        "ENGLISH", "MATHEMATICS", "CHEMISTRY",
        "BIOLOGY","PHYSICS", "GOVERNMENT","LIT ENGLISH",
        "Economics","History", "Geography","Agricultural Science",
        "Social Studies","French", "Igbo","Hausa","Yoruba","Home Economics",
        "Christian Religious Studies","ICT Information and Communication Technology (ICT)"
    )



    Column (
    modifier = modifier
        .fillMaxSize()
        ) {

    TabRow(
        selectedTabIndex = selectedIndex.value
    ) {
        tabNames.forEachIndexed { index, title ->
            Tab(
                selected = index == selectedIndex.value,
                onClick = {
                    when(title) {
                        ExamTabs.UTME.value -> {
                            selectedIndex.value = ExamTabs.UTME.ordinal
                        }
                        ExamTabs.WASSCE.value -> {
                            selectedIndex.value = ExamTabs.WASSCE.ordinal
                        }
                        ExamTabs.NECO.value -> {
                            selectedIndex.value = ExamTabs.NECO.ordinal
                        }

                    }
                },
                text = {
                    Text(title)
                       },
            )

        }

    }

    Surface(
        modifier = Modifier
            .weight(0.5f)
    ) {
        when(selectedIndex.value){
            ExamTabs.UTME.ordinal -> {
                ExamTabContent(
                    title = stringResource(id = R.string.utme_past_question_title),
                    subjects = subjects,
                    onExamSubjectClicked =  onExamSubjectClicked
                )
            }
            ExamTabs.WASSCE.ordinal -> {
                ExamTabContent(
                    title = stringResource(id = R.string.waec_past_question_title),
                    subjects = subjects,
                    onExamSubjectClicked = onExamSubjectClicked

                )
            }
            ExamTabs.NECO.ordinal -> {
                ExamTabContent(
                    title = stringResource(id = R.string.neco_past_question_title),
                    subjects = subjects,
                    onExamSubjectClicked = onExamSubjectClicked

                )
            }
        }



    }

}


}


private enum class ExamTabs(val value: String){
    UTME("UTME"),
    WASSCE("WASSCE"),
    NECO("NECO"),
}

@Preview
@Composable
fun ExamTabs() {
    ExamsScreen(
        onExamSubjectClicked = {}
    )

}