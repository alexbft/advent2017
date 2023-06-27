package day2part2

import bootstrap.Bootstrap

internal fun solve(lines: List<String>): Int {
    return lines.sumOf { line ->
        val nums = line.split(" ", "\t").map { it.toInt() }
        val num0 = nums.first { num -> nums.any { num2 -> num != num2 && num % num2 == 0 } }
        val num2 = nums.first { num -> num != num0 && num0 % num == 0 }
        num0 / num2
    }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
