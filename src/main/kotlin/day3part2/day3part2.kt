package day3part2

private data class Point(val x: Int, val y: Int)

internal fun solve(n: Int): Int {
    val values = mutableMapOf<Point, Int>()
    values[Point(0, 0)] = 1
    var result = 0
    fun fill(p: Point) {
        var sum = 0
        for (dy in -1..1) {
            for (dx in -1..1) {
                sum += values[Point(p.x + dx, p.y + dy)] ?: 0
            }
        }
        values[p] = sum
        if (result == 0 && sum > n) {
            result = sum
        }
    }
    for (i in 1..1000) {
        var start = Point(i, i - 1)
        val len = i * 2
        for (j in 0 until len) {
            fill(Point(start.x, start.y - j))
        }
        start = Point(i - 1, -i)
        for (j in 0 until len) {
            fill(Point(start.x - j, start.y))
        }
        start = Point(-i, -(i - 1))
        for (j in 0 until len) {
            fill(Point(start.x, start.y + j))
        }
        start = Point(-(i - 1), i)
        for (j in 0 until len) {
            fill(Point(start.x + j, start.y))
        }
        if (result > 0) {
            return result
        }
    }
    throw Exception("too big")
}

fun main() {
    println(solve(312051))
}
