package day9part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day9part1KtTest {

    @Test
    fun test1() {
        assertEquals(1, solve("{}"))
    }

    @Test
    fun test2() {
        assertEquals(6, solve("{{{}}}"))
    }

    @Test
    fun test3() {
        assertEquals(5, solve("{{},{}}"))
    }

    @Test
    fun test4() {
        assertEquals(16, solve("{{{},{},{{}}}}"))
    }

    @Test
    fun test5() {
        assertEquals(1, solve("{<a>,<a>,<a>,<a>}"))
    }

    @Test
    fun test6() {
        assertEquals(9, solve("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
    }

    @Test
    fun test7() {
        assertEquals(9, solve("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
    }

    @Test
    fun test8() {
        assertEquals(3, solve("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
    }
}
