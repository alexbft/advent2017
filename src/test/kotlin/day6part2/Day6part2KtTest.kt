package day6part2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6part2KtTest {

    @Test
    fun solveFull() {
        val input = "0 2 7 0"
        assertEquals(SolveResult(4, listOf(2, 4, 1, 2)), solveFull(input))
    }
}
