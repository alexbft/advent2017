package day12part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day12part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            0 <-> 2
            1 <-> 1
            2 <-> 0, 3, 4
            3 <-> 2, 4
            4 <-> 2, 3, 6
            5 <-> 6
            6 <-> 4, 5
        """.trimIndent().lines()
        assertEquals(2, solve(input))
    }
}
