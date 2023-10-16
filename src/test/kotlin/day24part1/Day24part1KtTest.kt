package day24part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day24part1KtTest {

    @Test
    fun solve() {
        val input = """
            0/2
            2/2
            2/3
            3/4
            3/5
            0/1
            10/1
            9/10
        """.trimIndent().lines()
        assertEquals(31, solve(input))
    }
}
