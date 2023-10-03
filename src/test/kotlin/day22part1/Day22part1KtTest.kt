package day22part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day22part1KtTest {

    private val inputText = """
        ..#
        #..
        ...
    """.trimIndent()

    @Test
    fun testSolve1() {
        assertEquals(5, solve(inputText, 7))
    }

    @Test
    fun testSolve2() {
        assertEquals(41, solve(inputText, 70))
    }

    @Test
    fun testSolve3() {
        assertEquals(5587, solve(inputText, 10000))
    }
}
