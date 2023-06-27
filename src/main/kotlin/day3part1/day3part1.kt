package day3part1

import kotlin.math.abs
import kotlin.math.sqrt

internal fun solve(n: Int): Int {
    var booba = sqrt(n.toDouble()).toInt()
    if (booba % 2 == 0) {
        booba -= 1
    }
    if (n == booba * booba) {
        val halfSize = booba / 2
        return halfSize * 2
    }
    val sideLength = booba + 2
    val pos = (n - booba * booba) % (sideLength - 1)
    val halfSize = sideLength / 2
    return halfSize + abs(pos - halfSize)
}

fun main() {
    println(solve(312051))
}
