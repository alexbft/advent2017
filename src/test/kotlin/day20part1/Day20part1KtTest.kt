package day20part1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day20part1KtTest {

    @Test
    fun solve() {
        val input = """
            p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>
            p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>
        """.trimIndent().lines()
        assertEquals(0, solve(input))
    }
}
