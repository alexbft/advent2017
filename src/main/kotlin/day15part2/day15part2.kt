package day15part2

private const val pairsNum = 5_000_000
private const val factorA = 16807L
private const val factorB = 48271L
private const val mask = (1L shl 16) - 1
private const val multA = 4L
private const val multB = 8L

private fun generate(prevValue: Long, factor: Long, mult: Long): Long {
    var value = prevValue
    while (true) {
        value = value * factor % 2147483647
        if (value % mult == 0L) {
            return value
        }
    }
}

fun solve(seedA: Int, seedB: Int): Int {
    var a = seedA.toLong()
    var b = seedB.toLong()
    var matches = 0
    for (iteration in 0 until pairsNum) {
        a = generate(a, factorA, multA)
        b = generate(b, factorB, multB)
        if ((a and mask) == (b and mask)) {
            ++matches
        }
    }
    return matches
}

fun main() {
    println(solve(783, 325))
}
