package day17part2naive

import java.util.LinkedList

// Go get a coffee, this would take a while
fun solve(lastNumber: Int, skip: Int): Int {
    val buffer = LinkedList<Int>()
    buffer.add(0)
    var position = buffer.listIterator()
    for (number in 1..lastNumber) {
        if (number % 1_000_000 == 0) {
            println("DEBUG $number")
        }
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
    for ((a, b) in buffer.zipWithNext()) {
        if (a == 0) {
            return b
        }
    }
    return buffer.first()
}

fun main() {
    println(solve(50_000_000, 349))
}
