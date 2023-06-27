package day9part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day9part2KtTest {

    @Test
    fun test1() {
        assertEquals(0, solve("<>"))
    }

    @Test
    fun test2() {
        assertEquals(17, solve("<random characters>"))
    }

    @Test
    fun test3() {
        assertEquals(3, solve("<<<<>"))
    }

    @Test
    fun test4() {
        assertEquals(2, solve("<{!>}>"))
    }

    @Test
    fun test5() {
        assertEquals(0, solve("<!!>"))
    }

    @Test
    fun test6() {
        assertEquals(0, solve("<!!!>>"))
    }

    @Test
    fun test7() {
        assertEquals(10, solve("<{o\"i!a,<{i<a>"))
    }
}
