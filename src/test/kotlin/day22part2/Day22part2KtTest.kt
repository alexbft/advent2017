package day22part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day22part2KtTest {

    private val inputText = """
        ..#
        #..
        ...
    """.trimIndent()

    @Test
    fun testSolve1() {
        assertEquals(26, solve(inputText, 100))
    }

    @Test
    fun testSolve2() {
        assertEquals(2511944, solve(inputText, MAX_TURNS))
    }

}
