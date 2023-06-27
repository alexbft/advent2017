package day2part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            5 9 2 8
            9 4 7 3
            3 8 6 5
        """.trimIndent().lines()
        assertEquals(9, solve(input))
    }
}
