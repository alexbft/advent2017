package day4part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day4part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            abcde fghij
            abcde xyz ecdab
            a ab abc abd abf abj
            iiii oiii ooii oooi oooo
            oiii ioii iioi iiio
        """.trimIndent().lines()
        assertEquals(3, solve(input))
    }
}
