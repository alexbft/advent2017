package day22part1

import bootstrap.Bootstrap

private data class Point(val x: Int, val y: Int)

const val MAX_TURNS = 10000

private val dirs = buildMap {
    put(0, Point(0, -1))
    put(1, Point(1, 0))
    put(2, Point(0, 1))
    put(3, Point(-1, 0))
}

fun solve(rawText: String, maxTurns: Int): Int {
    val checked = mutableSetOf<Point>()
    val lines = rawText.lines()
    for ((y, line) in lines.withIndex()) {
        for ((x, c) in line.withIndex()) {
            if (c == '#') {
                checked.add(Point(x, y))
            }
        }
    }
    val startX = lines.first().length / 2
    val startY = lines.size / 2
    var x = startX
    var y = startY
    var dir = 0 // 0 - up 1 - right 2 - down 3 - left
    var checkCount = 0
    for (turn in 0 until maxTurns) {
        val point = Point(x, y)
        val isChecked = point in checked
        dir = (dir + if (isChecked) 1 else 3) % 4
        if (isChecked) {
            checked.remove(point)
        } else {
            checked.add(point)
            checkCount += 1
        }
        val (dx, dy) = dirs[dir]!!
        x += dx
        y += dy
    }
    return checkCount
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText(), MAX_TURNS))
}
