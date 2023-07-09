package day10part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10part2KtTest {

    @Test
    fun test1() {
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", solve(""))
    }

    @Test
    fun test2() {
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", solve("AoC 2017"))
    }

    @Test
    fun test3() {
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", solve("1,2,3"))
    }

    @Test
    fun test4() {
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", solve("1,2,4"))
    }
}
