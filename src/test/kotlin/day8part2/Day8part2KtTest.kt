package day8part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day8part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            b inc 5 if a > 1
            a inc 1 if b < 5
            c dec -10 if a >= 1
            c inc -20 if c == 10
        """.trimIndent().lines()
        assertEquals(10, solve(input))
    }
}
