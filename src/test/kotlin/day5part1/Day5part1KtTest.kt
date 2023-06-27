package day5part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day5part1KtTest {

    @Test
    fun testSolve() {
        val input = """
            0
            3
            0
            1
            -3
        """.trimIndent().lines()
        assertEquals(5, solve(input))
    }
}
