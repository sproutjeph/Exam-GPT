package com.mbahjephthah.examgpt.features.exams.domain.model

data class QuestionOptions(
    val a: String,
    val b: String,
    val c: String,
    val d: String,
    val e: String
) {
    companion object {
        fun toList(questionOptions: QuestionOptions): List<String> {
            return listOf(questionOptions.a, questionOptions.b, questionOptions.c, questionOptions.d, questionOptions.e)
        }
    }
}

