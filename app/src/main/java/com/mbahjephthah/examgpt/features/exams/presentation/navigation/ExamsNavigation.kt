package com.mbahjephthah.examgpt.features.exams.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mbahjephthah.examgpt.features.exams.presentation.ExamsScreen

private const val examsGraphRoutePattern = "exams-graph"
const val examsRoute = "exams"


fun NavController.navigateToExamsGraph(navOptions: NavOptions? = null){
    this.navigate(examsGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.examsGraph(
    onExamSubjectClicked: (String)-> Unit,
    nestedGraphs: NavGraphBuilder.()-> Unit

){
    navigation(
        route = examsGraphRoutePattern,
        startDestination = examsRoute
    ){
        composable(route = examsRoute) {
            ExamsScreen(onExamSubjectClicked = onExamSubjectClicked)
        }
        nestedGraphs()
    }
}