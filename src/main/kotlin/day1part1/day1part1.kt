package day1part1

import bootstrap.Bootstrap

internal fun solve(text: String): Int {
    var sum = 0
    for ((i, c) in text.withIndex()) {
        val next = text[(i + 1) % text.length]
        if (c == next) {
            sum += c.digitToInt()
        }
    }
    return sum
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText()))
}
