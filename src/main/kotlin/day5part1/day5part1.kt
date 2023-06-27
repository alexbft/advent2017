package day5part1

import bootstrap.Bootstrap

internal fun solve(lines: List<String>): Int {
    val nums = lines.map { it.toInt() }.toMutableList()
    var pos = 0
    for (step in 0..1000000) {
        if (pos !in nums.indices) {
            return step
        }
        val newPos = pos + nums[pos]
        nums[pos] += 1
        pos = newPos
    }
    throw Exception("path too long or cycle")
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
