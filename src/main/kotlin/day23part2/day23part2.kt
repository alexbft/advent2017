package day23part2

import kotlin.math.sqrt

private fun isPrime(x: Int): Boolean {
    val xMid = sqrt(x.toDouble()).toInt()
    for (i in 2..xMid) {
        if (x % i == 0) {
            return false
        }
    }
    return true
}

fun main() {
    // reverse-engineered from input (see 23.txt)
    val b = 109900
    val c = 126900
    var h = 0
    for (n in b..c step 17) {
        if (!isPrime(n)) {
            ++h
        }
    }
    println(h)
}
