package day5part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day5part2KtTest {

    @Test
    fun solveFull() {
        val input = """
            0
            3
            0
            1
            -3
        """.trimIndent().lines()
        assertEquals(SolveResult(listOf(2, 3, 2, 3, -1), 10), solveFull(input))
    }
}
