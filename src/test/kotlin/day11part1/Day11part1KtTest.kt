package day11part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day11part1KtTest {

    @Test
    fun test1() {
        val input = "ne,ne,ne"
        assertEquals(3, solve(input))
    }

    @Test
    fun test2() {
        val input = "ne,ne,sw,sw"
        assertEquals(0, solve(input))
    }

    @Test
    fun test3() {
        val input = "ne,ne,s,s"
        assertEquals(2, solve(input))
    }

    @Test
    fun test4() {
        val input = "se,sw,se,sw,sw"
        assertEquals(3, solve(input))
    }
}
