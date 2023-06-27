package day7part1

import bootstrap.Bootstrap

fun solve(lines: List<String>): String {
    val lineRe = """(\w+) \((\d+)\)(?: -> (.+))?""".toRegex()
    val parentMap = mutableMapOf<String, String>()
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("Match failed at $line")
        val name = match.groupValues[1]
        val subNodes = match.groups[3]?.value?.split(", ") ?: emptyList()
        for (subNode in subNodes) {
            parentMap[subNode] = name
        }
    }
    var root = parentMap.keys.first()
    while (root in parentMap) {
        root = parentMap[root]!!
    }
    return root
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
