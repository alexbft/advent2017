package day18part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day18part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            snd 1
            snd 2
            snd p
            rcv a
            rcv b
            rcv c
            rcv d
        """.trimIndent().lines()
        assertEquals(3, solve(input))
    }
}
