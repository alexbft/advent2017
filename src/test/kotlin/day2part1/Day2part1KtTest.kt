package day2part1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2part1KtTest {

    @Test
    fun testSolve() {
        val input = """
            5 1 9 5
            7 5 3
            2 4 6 8
        """.trimIndent().lines()
        assertEquals(18, solve(input))
    }
}
