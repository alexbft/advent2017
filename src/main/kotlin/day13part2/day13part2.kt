package day13part2

import bootstrap.Bootstrap
import kotlin.math.max

private data class Guard(val pos: Int, val cycleLength: Int)

fun solve(lines: List<String>): Int {
    val guards = lines.map { line ->
        val (x, y) = line.split(": ").map { it.toInt() }
        Guard(x, max((y - 1) * 2, 1))
    }
    for (delay in 0..10000000) {
        if (guards.all { guard -> (guard.pos + delay) % guard.cycleLength != 0 }) {
            return delay
        }
    }
    throw Exception("not found")
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
