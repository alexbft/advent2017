package day22part2

import bootstrap.Bootstrap

private data class Point(val x: Int, val y: Int)

const val MAX_TURNS = 10_000_000

private val dirs = buildMap {
    put(0, Point(0, -1))
    put(1, Point(1, 0))
    put(2, Point(0, 1))
    put(3, Point(-1, 0))
}

private val stateToRotation = buildMap {
    put(0, 3)
    put(1, 0)
    put(2, 1)
    put(3, 2)
}

fun solve(rawText: String, maxTurns: Int): Int {
    val grid = mutableMapOf<Point, Int>()
    val lines = rawText.lines()
    for ((y, line) in lines.withIndex()) {
        for ((x, c) in line.withIndex()) {
            if (c == '#') {
                grid[Point(x, y)] = 2
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
        val state = grid[point] ?: 0
        if (state == 1) {
            ++checkCount
        }
        dir = (dir + stateToRotation[state]!!) % 4
        grid[point] = (state + 1) % 4
        val (dx, dy) = dirs[dir]!!
        x += dx
        y += dy
    }
    return checkCount
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText(), MAX_TURNS))
}
