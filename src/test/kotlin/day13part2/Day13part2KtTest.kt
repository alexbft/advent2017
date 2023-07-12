package day13part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day13part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            0: 3
            1: 2
            4: 4
            6: 4
        """.trimIndent().lines()
        assertEquals(10, solve(input))
    }
}
