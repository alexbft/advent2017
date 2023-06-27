package day1part1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1part1KtTest {

    @Test
    fun test1() {
        assertEquals(3, solve("1122"))
    }

    @Test
    fun test2() {
        assertEquals(4, solve("1111"))
    }

    @Test
    fun test3() {
        assertEquals(0, solve("1234"))
    }

    @Test
    fun test4() {
        assertEquals(9, solve("91212129"))
    }
}
