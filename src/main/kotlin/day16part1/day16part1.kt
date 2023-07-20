package day16part1

import bootstrap.Bootstrap

fun solve(size: Int, moves: List<String>): String {
    var state = "abcdefghijklmnop".take(size).toMutableList()
    for (move in moves) {
        when (move[0]) {
            's' -> {
                val splitIndex = size - move.substring(1).toInt()
                state = (state.slice(splitIndex until size) + state.slice(0 until splitIndex)).toMutableList()
            }
            'x' -> {
                val (a, b) = move.substring(1).split("/").map { it.toInt() }
                val tmp = state[a]
                state[a] = state[b]
                state[b] = tmp
            }
            'p' -> {
                val (aC, bC) = move.substring(1).split("/").map { it.single() }
                val a = state.indexOf(aC)
                val b = state.indexOf(bC)
                state[a] = bC
                state[b] = aC
            }
            else -> throw Exception("Unknown move $move")
        }
    }
    return state.joinToString("")
}

fun main(args: Array<String>) {
    println(solve(16, Bootstrap(args).readAllText().trimEnd().split(",")))
}
