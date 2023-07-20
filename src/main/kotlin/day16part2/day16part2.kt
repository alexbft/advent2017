package day16part2

import bootstrap.Bootstrap

fun applyMoves(initialState: String, moves: List<String>): String {
    val size = initialState.length
    var state = initialState.toMutableList()
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

fun solve(size: Int, moves: List<String>, cycles: Int): String {
    val initialState = "abcdefghijklmnop".take(size)
    var state = initialState
    val prevStates = mutableMapOf<String, Int>()
    for (i in 0 until 10_000_000) {
        if (i >= cycles) {
            return state
        }
        if (state !in prevStates) {
            prevStates[state] = i
            state = applyMoves(state, moves)
            continue
        }
        val cycleStart = prevStates[state]!!
        val cycleLength = i - cycleStart
        val cycleIndex = (cycles - cycleStart) % cycleLength
        for (j in 0 until cycleIndex) {
            state = applyMoves(state, moves)
        }
        return state
    }
    throw Exception("cycle not found")
}

fun main(args: Array<String>) {
    println(solve(16, Bootstrap(args).readAllText().trimEnd().split(","), 1_000_000_000))
}
