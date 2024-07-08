package com.example.assessment.logictest

class LogicAssessment {

    // Assessment 1
    fun findBalancedIndex(numbers: List<Int>): Any {
        var leftSum = 0
        var rightSum = numbers.sum() - (numbers.firstOrNull() ?: 0)
        for (i in 1 until numbers.size - 1) {
            leftSum += numbers[i - 1]
            rightSum -= numbers[i]
            if (leftSum == rightSum) {
                return "middle index is $i"
            }
        }
        return "index not found"
    }

    // Assessment 2
    fun isPalindrome(text: String): String {
        val length = text.length
        for (i in 0 until length / 2) {
            if (text[i].lowercaseChar() != text[(length - i - 1)].lowercaseChar()) {
                return "$text isn't a palindrome"
            }
        }
        return "$text is a palindrome"
    }


    // Assessment 3
    fun findTripletsOfZero(numbers: List<Int>): Set<List<Int>> {
        if (numbers.size < 3) return emptySet()

        val answer = arrayListOf<List<Int>>()
        // Separate for reduce complexity when N is big value
        val minusList = arrayListOf<Int>()
        val plusList = arrayListOf<Int>()
        for (i in numbers.sorted()) {
            if (i < 0) {
                minusList.add(i)
            } else {
                plusList.add(i)
            }
        }

        for (i in 0 until minusList.size - 1) {
            for (j in i + 1 until minusList.size) {
                val iValue = minusList[i]
                val jValue = minusList[j]
                val remainValue = -(iValue + minusList[j])
                if (remainValue in plusList) {
                    answer.add(listOf(iValue, jValue, remainValue))
                }
            }
        }

        for (i in 0 until plusList.size - 1) {
            for (j in i + 1 until plusList.size) {
                val iValue = plusList[i]
                val jValue = plusList[j]
                val remainValue = -(iValue + plusList[j])
                if (remainValue in minusList) {
                    answer.add(listOf(iValue, jValue, remainValue))
                }
            }
        }
        return answer.map { it.sorted() }.toSet()
    }

}
