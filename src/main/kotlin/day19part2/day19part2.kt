package day19part2

import bootstrap.Bootstrap

private data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}
private typealias Vector = Point

private fun getChar(rows: List<String>, point: Point): Char {
    if (point.y in rows.indices && point.x in rows[point.y].indices) {
        return rows[point.y][point.x]
    }
    return ' '
}

private fun getSideDirs(dir: Vector): List<Vector> {
    if (dir.x == 0) {
        return listOf(Vector(-1, 0), Vector(1, 0))
    }
    return listOf(Vector(0, -1), Vector(0, 1))
}

data class SolveResult(val collected: String, val steps: Int)

fun solveFull(rawText: String): SolveResult {
    val rows = rawText.lines()
    val startY = 0
    val startX = rows[0].indexOf('|')
    var pos = Point(startX, startY)
    var dir = Vector(0, 1)
    val collected = mutableListOf<Char>()
    var steps = 0
    do {
        val c = getChar(rows, pos)
        if (c in 'A'..'Z') {
            collected.add(c)
        } else if (c == '+') {
            val sideDirs = getSideDirs(dir)
            dir = sideDirs.first { sideDir -> getChar(rows, pos + sideDir) != ' ' }
        } else if (c == ' ') {
            break
        }
        pos += dir
        ++steps
    } while (true)
    return SolveResult(collected.joinToString(""), steps)
}

private fun solve(rawText: String): Int {
    return solveFull(rawText).steps
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText()))
}
