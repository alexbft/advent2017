package day17part1

import java.util.LinkedList

fun solve(lastNumber: Int, skip: Int): Int {
    val buffer = LinkedList<Int>()
    buffer.add(0)
    var position = buffer.listIterator()
    for (number in 1..lastNumber) {
        for (i in 0 until skip) {
            position.next()
            if (!position.hasNext()) {
                position = buffer.listIterator()
            }
        }
        position.next()
        position.add(number)
        position.previous()
    }
    position.next()
    return if (position.hasNext()) position.next() else buffer.first()
}

fun main() {
    println(solve(2017, 349))
}
