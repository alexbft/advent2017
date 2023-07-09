package day11part2

import bootstrap.Bootstrap
import kotlin.math.abs
import kotlin.math.max

private data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

private fun dirToVector(dir: String): Point {
    return when (dir) {
        "n" -> Point(0, -1)
        "ne" -> Point(1, -1)
        "se" -> Point(1, 0)
        "s" -> Point(0, 1)
        "nw" -> Point(-1, 0)
        "sw" -> Point(-1, 1)
        else -> throw Exception("unknown $dir")
    }
}

private fun distance(point: Point): Int {
    val (x, y) = point
    val dx = abs(x)
    var dy = abs(y)
    // Calculate manhattan distance, then account for NE and SW moves
    if (x > 0 && y < 0 || x < 0 && y > 0) {
        // Use NE or SW moves to cut the Y distance
        dy = max(0, dy - dx)
    }
    return dx + dy
}

fun solve(inputText: String): Int {
    val steps = inputText.trim().split(",")
    return steps.scan(Point(0, 0)) { pos, step -> pos + dirToVector(step) }.maxOf(::distance)
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText()))
}
