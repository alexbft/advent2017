package day6part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6part1KtTest {

    @Test
    fun solveFull() {
        val input = "0 2 7 0"
        assertEquals(SolveResult(5, listOf(2, 4, 1, 2)), solveFull(input))
    }
}
