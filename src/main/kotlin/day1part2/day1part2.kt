package day1part2

import bootstrap.Bootstrap

internal fun solve(text: String): Int {
    var sum = 0
    val l = text.length / 2
    for ((i, c) in text.withIndex()) {
        val next = text[(i + l) % text.length]
        if (c == next) {
            sum += c.digitToInt()
        }
    }
    return sum
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText()))
}
