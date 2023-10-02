package day21part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day21part1KtTest {

    @Test
    fun testSolve() {
        val input = """
            ../.# => ##./#../...
            .#./..#/### => #..#/..../..../#..#
        """.trimIndent().lines()
        assertEquals(12, solve(input, 2))
    }
}
