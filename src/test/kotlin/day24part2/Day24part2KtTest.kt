package day24part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day24part2KtTest {

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
        assertEquals(19, solve(input))
    }
}
