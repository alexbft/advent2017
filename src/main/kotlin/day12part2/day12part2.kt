package day12part2

import bootstrap.Bootstrap

fun solve(lines: List<String>): Int {
    val lineRe = """(\d+) <-> (\d+(?:, \d+)*)""".toRegex()
    val graph = mutableMapOf<Int, Set<Int>>()
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("fail to match")
        val nodeFrom = match.groupValues[1].toInt()
        val nodesTo = match.groupValues[2].split(", ").map { it.toInt() }.toSet()
        graph[nodeFrom] = nodesTo
    }
    val discovered = mutableSetOf<Int>()
    var componentCount = 0
    for (startNode in graph.keys) {
        if (startNode in discovered) {
            continue
        }
        ++componentCount
        val stack = ArrayDeque<Int>()
        stack.addLast(startNode)
        while (stack.isNotEmpty()) {
            val cur = stack.removeLast()
            if (cur !in discovered) {
                discovered.add(cur)
                stack.addAll(graph[cur]!!)
            }
        }
    }
    return componentCount
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
