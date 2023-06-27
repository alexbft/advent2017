package day4part1

import bootstrap.Bootstrap

internal fun solve(lines: List<String>): Int {
    return lines.count { line ->
        val words = line.split(" ")
        words.size == words.distinct().size
    }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
