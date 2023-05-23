package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.RealEstateAgent
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Destination(
    val path: String,
    val icon: ImageVector? = null,
    val isRootDestination: Boolean = true

) {

    companion object {
        fun fromString(route: String?): Destination {
            return when (route) {
                Home.path -> Home
                Exams.path -> Exams
                Profile.path -> Profile
                Books.path -> Books
                Ai.path -> Ai
                else -> Exams
            }
        }
    }

    object Home : Destination("home", Icons.Filled.Home)
    object Exams : Destination("exams", Icons.Filled.School)
    object Profile : Destination("profile", Icons.Filled.AccountCircle)
    object Books : Destination("books", Icons.Filled.Book)
    object Ai : Destination("ai", Icons.Filled.RealEstateAgent)

    object Settings : Destination(
        path = "settings",
      icon =  Icons.Default.Settings,
        isRootDestination = false
    )
    object Upgrade : Destination(
        path = "upgrade",
      icon =  Icons.Default.CloudUpload,
        isRootDestination = false
    )

    object ExamYears : Destination(
        path = "exam-years/english",
        isRootDestination = false
    )

    object ExamYearQuestion : Destination(
        path = "exam-year-question/2022",
        isRootDestination = false
    )









}
