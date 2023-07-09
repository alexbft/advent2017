package day10part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10part1KtTest {

    @Test
    fun solveFull() {
        val expected = listOf(3, 4, 2, 1, 0)
        assertEquals(expected, solveFull(listOf(0, 1, 2, 3, 4), listOf(3, 4, 1, 5)))
    }
}
