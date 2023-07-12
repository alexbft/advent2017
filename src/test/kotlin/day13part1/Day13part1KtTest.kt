package day13part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day13part1KtTest {

    @Test
    fun testSolve() {
        val input = """
            0: 3
            1: 2
            4: 4
            6: 4
        """.trimIndent().lines()
        assertEquals(24, solve(input))
    }
}
