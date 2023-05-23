package com.mbahjephthah.examgpt.features.exams.presentation.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mbahjephthah.examgpt.features.exams.presentation.QuestionScreen

const val questionArg = "questionYear"

class QuestionArgs(val questionYear: String){
    constructor(savedStateHandle: SavedStateHandle, stringDecoder: StringDecoder):
            this(stringDecoder.decodeString(checkNotNull(savedStateHandle[examNameArg])))
}



fun NavController.navigateToQuestionScreen(questionYear: String){
    val encodedId = Uri.encode(questionYear)
    this.navigate("exam-year-question/$encodedId")
}


fun NavGraphBuilder.questionScreen(
    onBackClick: () -> Unit,
    onAskAiClicked: (String) -> Unit
){

    composable(
        route = "exam-year-question/{$examNameArg}",
        arguments = listOf(
            navArgument(examNameArg){type = NavType.StringType},
        )
    ){

        QuestionScreen(
            onAskAiClicked = onAskAiClicked
        )
    }

}
