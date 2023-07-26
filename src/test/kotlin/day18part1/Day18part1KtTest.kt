package day18part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day18part1KtTest {

    @Test
    fun testSolve() {
        val input = """
            set a 1
            add a 2
            mul a a
            mod a 5
            snd a
            set a 0
            rcv a
            jgz a -1
            set a 1
            jgz a -2
        """.trimIndent().lines()
        assertEquals(4L, solve(input))
    }

    @Test
    fun testLongNumbers() {
        val input = """
            set a 1000000
            mul a a
            mod a 12345
            snd a
            rcv a
        """.trimIndent().lines()
        assertEquals(3025L, solve(input))
    }
}
