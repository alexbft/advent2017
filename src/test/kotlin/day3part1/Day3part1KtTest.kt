package day3part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3part1KtTest {

    @Test
    fun test1() {
        assertEquals(0, solve(1))
    }

    @Test
    fun test2() {
        assertEquals(3, solve(12))
    }

    @Test
    fun test3() {
        assertEquals(2, solve(23))
    }

    @Test
    fun test4() {
        assertEquals(31, solve(1024))
    }
}
