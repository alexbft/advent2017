package day4part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day4part1KtTest {

    @Test
    fun testSolve() {
        val input = """
            aa bb cc dd ee
            aa bb cc dd aa
            aa bb cc dd aaa
        """.trimIndent().lines()
        assertEquals(2, solve(input))
    }
}
