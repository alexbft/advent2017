package day19part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day19part1KtTest {

    @Test
    fun testSolve() {
        val input = """
                 |          
                 |  +--+    
                 A  |  C    
             F---|----E|--+ 
                 |  |  |  D 
                 +B-+  +--+ 
        """.trimIndent()
        assertEquals("ABCDEF", solve(input))
    }
}
