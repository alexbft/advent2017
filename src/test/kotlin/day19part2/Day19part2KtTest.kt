package day19part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day19part2KtTest {

    @Test
    fun testSolveFull() {
        val input = """
                 |          
                 |  +--+    
                 A  |  C    
             F---|----E|--+ 
                 |  |  |  D 
                 +B-+  +--+ 
        """.trimIndent()
        assertEquals(SolveResult("ABCDEF", 38), solveFull(input))
    }
}
