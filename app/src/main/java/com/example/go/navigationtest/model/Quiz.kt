package com.example.go.navigationtest.model

import java.io.Serializable

data class Quiz(
    val mQuiz: String,
    val mChoices: List<String>,
    val mAns: Int
) : Serializable {
    companion object {
        val sDummyData: List<Quiz> = listOf(
            Quiz("Quiz 1", listOf("Ans 11", "Ans 12", "Ans 13"), 1),
            Quiz("Quiz 2", listOf("Ans 21", "Ans 22", "Ans 23"), 2),
            Quiz("Quiz 3", listOf("Ans 31", "Ans 32", "Ans 33"), 3)
        )
    }
}