package day10part2

import bootstrap.Bootstrap

private class Knitter(initialItems: List<Int>) {
    private var skip = 0
    private var curIndex = 0
    private val _items: MutableList<Int>
    val items: List<Int>
        get() = _items.toList()

    init {
        _items = initialItems.toMutableList()
    }

    fun knit(knotLength: Int) {
        reverse(curIndex, knotLength)
        curIndex = move(curIndex, knotLength + skip)
        skip += 1
    }

    fun knitMany(knotLengths: List<Int>) {
        for (l in knotLengths) {
            knit(l)
        }
    }

    private fun move(index: Int, steps: Int): Int {
        val newIndex = (index + steps) % _items.size
        return if (newIndex < 0) newIndex + _items.size else newIndex
    }

    private fun reverse(start: Int, rangeLength: Int) {
        if (rangeLength > _items.size) {
            throw Exception("range too long")
        }
        var l = start
        var r = move(start + rangeLength, -1)
        var steps = rangeLength
        while (steps >= 2) {
            val temp = _items[l]
            _items[l] = _items[r]
            _items[r] = temp
            l = move(l, 1)
            r = move(r, -1)
            steps -= 2
        }
    }
}

fun solve(inputText: String): String {
    val initialItems = (0..255).toList()
    val knotLengths = buildList {
        addAll(inputText.trim().toByteArray(Charsets.US_ASCII).map { it.toInt() })
        addAll(listOf(17, 31, 73, 47, 23))
    }
    val knotLengths64 = (0 until 64).flatMap { knotLengths }
    val result = Knitter(initialItems).also { it.knitMany(knotLengths64) }.items
    val chunks = result.chunked(16) { chunk -> chunk.reduce { a, b -> a xor b } }
    return chunks.joinToString("") { "%02x".format(it) }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText()))
}
