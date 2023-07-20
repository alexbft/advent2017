package day16part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day16part1KtTest {

    @Test
    fun testSolve() {
        val input = listOf("s1", "x3/4", "pe/b")
        assertEquals("baedc", solve(5, input))
    }
}
