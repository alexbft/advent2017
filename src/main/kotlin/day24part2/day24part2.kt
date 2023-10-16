package day24part2

import bootstrap.Bootstrap

private data class Domino(val a: Int, val b: Int) {
    val sum: Int get() = a + b
}

private data class Result(val length: Int, val totalSum: Int)

private fun rec(lastPiece: Int, pieces: List<Domino>): Result {
    var maxResult = Result(0, 0)
    for (piece in pieces) {
        val recResult = if (piece.a == lastPiece) {
            rec(piece.b, pieces.filter { it !== piece })
        } else if (piece.b == lastPiece) {
            rec(piece.a, pieces.filter { it !== piece })
        } else {
            null
        }
        if (recResult != null) {
            val tempResult = Result(recResult.length + 1, recResult.totalSum + piece.sum)
            if (tempResult.length > maxResult.length || tempResult.length == maxResult.length && tempResult.totalSum > maxResult.totalSum) {
                maxResult = tempResult
            }
        }
    }
    return maxResult
}

fun solve(lines: List<String>): Int {
    val dominoes = lines.map { line ->
        val (a, b) = line.split("/").map { it.toInt() }
        Domino(a, b)
    }
    return rec(0, dominoes).totalSum
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
