package day2part1

import bootstrap.Bootstrap

internal fun solve(lines: List<String>): Int {
    return lines.sumOf { line ->
        val nums = line.split(" ", "\t").map { it.toInt() }
        nums.max() - nums.min()
    }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
