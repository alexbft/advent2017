package day20part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day20part2KtTest {

    @Test
    fun solve() {
        val input = """
            p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>
            p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>
            p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>
            p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>
        """.trimIndent().lines()
        assertEquals(1, solve(input))
    }
}
