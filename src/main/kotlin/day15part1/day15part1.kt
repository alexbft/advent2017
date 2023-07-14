package day15part1

private const val pairsNum = 40_000_000
private const val factorA = 16807L
private const val factorB = 48271L
private const val mask = (1L shl 16) - 1

private fun generate(prevValue: Long, factor: Long): Long {
    return prevValue * factor % 2147483647
}

fun solve(seedA: Int, seedB: Int): Int {
    var a = seedA.toLong()
    var b = seedB.toLong()
    var matches = 0
    for (iteration in 0 until pairsNum) {
        a = generate(a, factorA)
        b = generate(b, factorB)
        if ((a and mask) == (b and mask)) {
            ++matches
        }
    }
    return matches
}

fun main() {
    println(solve(783, 325))
}
