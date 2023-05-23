package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mbahjephthah.examgpt.features.ai.presentation.AiInteractionScreen
import com.mbahjephthah.examgpt.features.exams.presentation.navigation.examYearsScreen
import com.mbahjephthah.examgpt.features.exams.presentation.navigation.examsGraph
import com.mbahjephthah.examgpt.features.exams.presentation.navigation.questionScreen
import com.mbahjephthah.examgpt.ui.screens.home_screen.HomeScreen


@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    startDestination: String = Destination.Home.path,
    navController: NavHostController,
) {


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,

        ){


            composable(route = Destination.Home.path){

                HomeScreen(

                )

            }


            examsGraph(
                onExamSubjectClicked = {
                    navController.navigate(Destination.ExamYears.path)
                },
                nestedGraphs = {
                    examYearsScreen(
                        onExamYearClick = {navController.navigate(Destination.ExamYearQuestion.path)},
                        onBackClick = {}
                    )

                    questionScreen(
                        onAskAiClicked = {
                            navController.navigate(Destination.Ai.path)
                        },
                        onBackClick = {}
                    )

                }
            )






            composable(route = Destination.Profile.path){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Profile")
                }
            }

            composable(route = Destination.Books.path){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Books")
                }
            }

            composable(route = Destination.Ai.path){
                AiInteractionScreen()
            }








        composable(route = Destination.Settings.path){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Settings")
            }
        }

        composable(route = Destination.Upgrade.path){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Upgrade")
            }
        }





    }

}