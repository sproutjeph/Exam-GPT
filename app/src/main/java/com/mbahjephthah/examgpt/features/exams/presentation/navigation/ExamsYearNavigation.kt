package com.mbahjephthah.examgpt.features.exams.presentation.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mbahjephthah.examgpt.features.exams.presentation.ExamYearsScreen

const val examNameArg = "examName"

class ExamArgs(val examName: String){
    constructor(savedStateHandle: SavedStateHandle, stringDecoder: StringDecoder):
            this(stringDecoder.decodeString(checkNotNull(savedStateHandle[examNameArg])))
}



fun NavController.navigateToExamYear(examName: String){
    val encodedId = Uri.encode(examName)
    this.navigate("exam-years/$encodedId")
}


fun NavGraphBuilder.examYearsScreen(
    onBackClick: () -> Unit,
    onExamYearClick: (String) -> Unit
){

    composable(
        route = "exam-years/{$examNameArg}",
        arguments = listOf(
            navArgument(examNameArg){type = NavType.StringType},
        )
    ){
        ExamYearsScreen(
            onBackClicked = onBackClick,
            onExamYearClicked = onExamYearClick
        )
    }

}




interface StringDecoder {
    fun decodeString(encodedString: String): String
}