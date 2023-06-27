package day7part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7part2KtTest {

    @Test
    fun testSolve() {
        val input = """
            pbga (66)
            xhth (57)
            ebii (61)
            havc (66)
            ktlj (57)
            fwft (72) -> ktlj, cntj, xhth
            qoyq (66)
            padx (45) -> pbga, havc, qoyq
            tknk (41) -> ugml, padx, fwft
            jptl (61)
            ugml (68) -> gyxo, ebii, jptl
            gyxo (61)
            cntj (57)
        """.trimIndent().lines()
        assertEquals(60, solve(input))
    }
}
