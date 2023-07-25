package day17part2

fun solve(lastNumber: Int, skip: Int): Int {
    var pos = 0
    var numberAfterZero = 0
    for (nextNumber in 1..lastNumber) {
        if (pos == 0) {
            numberAfterZero = nextNumber
        }
        pos = (pos + 1 + skip) % (nextNumber + 1)
    }
    return numberAfterZero
}

fun main() {
    println(solve(50_000_000, 349))
}
