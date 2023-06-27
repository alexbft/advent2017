package day5part2

import bootstrap.Bootstrap

data class SolveResult(val nums: List<Int>, val steps: Int)

internal fun solveFull(lines: List<String>): SolveResult {
    val nums = lines.map { it.toInt() }.toMutableList()
    var pos = 0
    for (step in 0..100_000_000) {
        if (pos !in nums.indices) {
            return SolveResult(nums, step)
        }
        val newPos = pos + nums[pos]
        nums[pos] = if (nums[pos] >= 3) nums[pos] - 1 else nums[pos] + 1
        pos = newPos
    }
    throw Exception("path too long or cycle")
}

private fun solve(lines: List<String>): Int {
    return solveFull(lines).steps
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
