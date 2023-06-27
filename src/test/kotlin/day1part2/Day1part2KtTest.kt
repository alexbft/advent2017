package day1part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1part2KtTest {

    @Test
    fun test1() {
        assertEquals(6, solve("1212"))
    }

    @Test
    fun test2() {
        assertEquals(0, solve("1221"))
    }

    @Test
    fun test3() {
        assertEquals(4, solve("123425"))
    }

    @Test
    fun test4() {
        assertEquals(12, solve("123123"))
    }

    @Test
    fun test5() {
        assertEquals(4, solve("12131415"))
    }
}
