package com.example.assessment

import com.example.assessment.logictest.LogicAssessment
import org.junit.Assert.assertEquals
import org.junit.Test

class LogicAssessmentTest {

    private val logicAssessment = LogicAssessment()


    // Assessment 1
    @Test
    fun `recheck findBalancedIndex should work properly`() {
        listOf(1, 3, 5, 7, 9).checkMiddleAnswerIs("middle index is 3")
        listOf(3, 6, 8, 1, 5, 10, 1, 7).checkMiddleAnswerIs("middle index is 4")
        listOf(3, 5, 6).checkMiddleAnswerIs("index not found")
    }

    private fun List<Int>.checkMiddleAnswerIs(expected: String) {
        assertEquals(expected, logicAssessment.findBalancedIndex(this))
    }


    // Assessment 2
    @Test
    fun `recheck isPalindrome should work properly`() {
        "aka".checkPalindromeAnswerIs(true)
        "Level".checkPalindromeAnswerIs(true)
        "Hello".checkPalindromeAnswerIs(false)
        "Helleh".checkPalindromeAnswerIs(true)
        "a".checkPalindromeAnswerIs(true)
        "aa".checkPalindromeAnswerIs(true)
    }

    private fun String.checkPalindromeAnswerIs(isPalindrome: Boolean) {
        val expected = "$this is" + if (isPalindrome) " a palindrome" else "n't a palindrome"
        assertEquals(expected, logicAssessment.isPalindrome(this))
    }


    // Assessment 3
    @Test
    fun `recheck findTripletsOfZero should work properly`() {
        listOf(-1, -5, -3, 0, 1, 2, -1)
            .checkAnswerTripletsOfZeroIs(
                setOf(
                    listOf(-3, 1, 2),
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            )
        listOf(-1, -1, -1, 0, 1, 1, 1)
            .checkAnswerTripletsOfZeroIs(
                setOf(
                    listOf(-1, 0, 1)
                )
            )
        listOf(1, 1, 2)
            .checkAnswerTripletsOfZeroIs(
                emptySet()
            )
    }

    private fun List<Int>.checkAnswerTripletsOfZeroIs(expected: Set<List<Int>>) {
        assertEquals(expected, logicAssessment.findTripletsOfZero(this))
    }

}
