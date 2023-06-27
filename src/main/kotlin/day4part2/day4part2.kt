package day4part2

import bootstrap.Bootstrap

internal fun solve(lines: List<String>): Int {
    return lines.count { line ->
        val words = line.split(" ")
        for ((i, word1) in words.withIndex()) {
            for ((j, word2) in words.withIndex()) {
                if (i != j && word1.toList().sorted() == word2.toList().sorted()) {
                    return@count false
                }
            }
        }
        true
    }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
