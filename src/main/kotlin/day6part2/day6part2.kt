package day6part2

import bootstrap.Bootstrap

data class SolveResult(val cycleLength: Int, val state: List<Int>)

fun solveFull(text: String): SolveResult {
    val splitRe = """\s+""".toRegex()
    val initialState = text.trim().split(splitRe).map { it.toInt() }
    val prevStates = mutableMapOf<List<Int>, Int>()
    val state = initialState.toMutableList()
    val l = state.size
    for (step in 0..1000000) {
        if (state in prevStates) {
            return SolveResult(step - prevStates[state]!!, state)
        }
        prevStates[state.toList()] = step
        val (maxIndex, maxNum) = state.withIndex().maxBy { it.value }
        val quot = maxNum / l
        val rem = maxNum % l
        state[maxIndex] = 0
        for (shift in 0 until rem) {
            state[(maxIndex + 1 + shift) % l] += quot + 1
        }
        for (shift in rem until l) {
            state[(maxIndex + 1 + shift) % l] += quot
        }
    }
    throw Exception("cycle too long")
}

private fun solve(text: String): Int {
    return solveFull(text).cycleLength
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText()))
}
