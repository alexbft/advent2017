package day21part1

import bootstrap.Bootstrap
import kotlin.math.sqrt

data class Pattern(val sideSize: Int, val chars: String) {
    init {
        assert(chars.length == sideSize * sideSize)
    }

    fun row(index: Int): String {
        return chars.substring(index * sideSize, (index + 1) * sideSize)
    }

    private fun rows(): List<String> {
        return chars.chunked(sideSize)
    }

    fun split(chunkSideSize: Int): List<Pattern> {
        return buildList {
            for (rowsChunk in rows().chunked(chunkSideSize)) {
                val splints = rowsChunk.map { it.chunked(chunkSideSize) }
                val patternBuilders = List(splints.first().size) { StringBuilder() }
                for (row in splints) {
                    row.zip(patternBuilders) {splint, patternBuilder ->
                        patternBuilder.append(splint)
                    }
                }
                addAll(patternBuilders.map { Pattern(chunkSideSize, it.toString()) })
            }
        }
    }

    private fun flipY(): Pattern {
        return Pattern(sideSize, rows().asReversed().joinToString(""))
    }

    private fun rotate(): Pattern {
        val result = buildString {
            for (x in 0 until sideSize) {
                for (y in (sideSize - 1) downTo 0) {
                    append(chars[y * sideSize + x])
                }
            }
        }
        return Pattern(sideSize, result)
    }

    fun allVariations(): List<Pattern> {
        val result = buildList<Pattern> {
            var temp = this@Pattern
            for (i in 0..3) {
                add(temp)
                temp = temp.rotate()
            }
            temp = flipY()
            for (i in 0..3) {
                add(temp)
                temp = temp.rotate()
            }
        }
        return result.distinctBy { it.chars }
    }

    companion object {
        fun join(patterns: List<Pattern>): Pattern {
            val patternSideSize = patterns.first().sideSize
            val patternsBySide = sqrt(patterns.size.toDouble()).toInt()
            val result = mutableListOf<String>()
            for (chunk in patterns.chunked(patternsBySide)) {
                for (rowIndex in 0 until patternSideSize) {
                    for (pattern in chunk) {
                        result.add(pattern.row(rowIndex))
                    }
                }
            }
            return Pattern(patternSideSize * patternsBySide, result.joinToString(""))
        }
    }
}

fun solve(rules: List<String>, iterations: Int): Int {
    val ruleMap = mutableMapOf<Pattern, Pattern>()
    for (rule in rules) {
        val (sFrom, sTo) = rule.split(" => ").map { it.replace("/", "") }
        val pFrom: Pattern
        val pTo: Pattern
        if (sFrom.length == 4) {
            pFrom = Pattern(2, sFrom)
            pTo = Pattern(3, sTo)
        } else {
            pFrom = Pattern(3, sFrom)
            pTo = Pattern(4, sTo)
        }
        for (variation in pFrom.allVariations()) {
            ruleMap[variation] = pTo
        }
    }
    val start = Pattern(3, ".#...####")
    var cur = start
    for (iteration in 0 until iterations) {
        val chunks = if (cur.sideSize % 2 == 0) cur.split(2) else cur.split(3)
        val newChunks = chunks.map { ruleMap[it] ?: throw Exception("Rule not found for $it") }
        cur = Pattern.join(newChunks)
    }
    return cur.chars.count { it == '#' }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines(), 5))
}
