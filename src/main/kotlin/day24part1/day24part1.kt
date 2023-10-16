package day24part1

import bootstrap.Bootstrap

private data class Domino(val a: Int, val b: Int) {
    val sum: Int get() = a + b
}

private fun rec(lastPiece: Int, pieces: List<Domino>): Int {
    var maxSum = 0
    for (piece in pieces) {
        if (piece.a == lastPiece) {
            maxSum = maxOf(maxSum, piece.sum + rec(piece.b, pieces.filter { it !== piece }))
        } else if (piece.b == lastPiece) {
            maxSum = maxOf(maxSum, piece.sum + rec(piece.a, pieces.filter { it !== piece }))
        }
    }
    return maxSum
}

fun solve(lines: List<String>): Int {
    val dominoes = lines.map { line ->
        val (a, b) = line.split("/").map { it.toInt() }
        Domino(a, b)
    }
    return rec(0, dominoes)
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
