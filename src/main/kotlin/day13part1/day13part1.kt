package day13part1

import bootstrap.Bootstrap
import kotlin.math.max

fun solve(lines: List<String>): Int {
    var result = 0
    for (line in lines) {
        val (x, y) = line.split(": ").map { it.toInt() }
        val cycleLength = max((y - 1) * 2, 1)
        if (x % cycleLength == 0) {
            result += x * y
        }
    }
    return result
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
