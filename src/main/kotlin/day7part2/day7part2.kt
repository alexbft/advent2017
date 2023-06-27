package day7part2

import bootstrap.Bootstrap

private class Solver(parentMap: Map<String, String>, private val weightMap: Map<String, Int>) {
    private val root: String
    private val subNodeMap: Map<String, List<String>>
    private val totalWeightMap = mutableMapOf<String, Int>()

    init {
        var temp = parentMap.keys.first()
        while (temp in parentMap) {
            temp = parentMap[temp]!!
        }
        root = temp
        subNodeMap = parentMap.entries.groupBy({ it.value }, { it.key })
        calcTotalWeight(root)
    }

    private fun subNodes(node: String): List<String> {
        return subNodeMap[node] ?: emptyList()
    }

    private fun calcTotalWeight(node: String) {
        for (subNode in subNodes(node)) {
            calcTotalWeight(subNode)
        }
        totalWeightMap[node] = weightMap[node]!! + subNodes(node).sumOf { totalWeightMap[it]!! }
    }

    private fun findProblemNode(startNode: String, requiredTotalWeight: Int): Int? {
        var node = startNode
        var requiredWeight = requiredTotalWeight
        while (true) {
            val children = subNodes(node)
            //println("DBG looking at $node, reqWeight: $requiredWeight, node weight: ${weightMap[node]}, children weight: ${children.map { totalWeightMap[it] }}")
            if (children.isEmpty()) {
                return requiredWeight
            }
            if (children.all { child -> totalWeightMap[child] == totalWeightMap[children[0]] }) {
                return requiredWeight - totalWeightMap[node]!! + weightMap[node]!!
            }
            val childrenTotalWeight = requiredWeight - weightMap[node]!!
            if (childrenTotalWeight % children.size != 0) {
                return null
            }
            val childWeight = childrenTotalWeight / children.size
            val childrenWithDifferentWeight = children.filter { subNode -> totalWeightMap[subNode] != childWeight }
            if (childrenWithDifferentWeight.size != 1) {
                return null
            }
            node = childrenWithDifferentWeight.single()
            requiredWeight = childWeight
        }
    }

    fun solve(): Int {
        for (rootChild in subNodes(root)) {
            val childrenWithDifferentWeight = subNodes(root).filter { node -> totalWeightMap[node] != totalWeightMap[rootChild] }
            if (childrenWithDifferentWeight.size == 1) {
                val maybeResult = findProblemNode(childrenWithDifferentWeight.single(), totalWeightMap[rootChild]!!)
                if (maybeResult != null){
                    return maybeResult
                }
            }
        }
        throw Exception("No solution")
    }
}

fun solve(lines: List<String>): Int {
    val lineRe = """(\w+) \((\d+)\)(?: -> (.+))?""".toRegex()
    val parentMap = mutableMapOf<String, String>()
    val weightMap = mutableMapOf<String, Int>()
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("Match failed at $line")
        val name = match.groupValues[1]
        val subNodes = match.groups[3]?.value?.split(", ") ?: emptyList()
        for (subNode in subNodes) {
            parentMap[subNode] = name
        }
        val weight = match.groupValues[2].toInt()
        weightMap[name] = weight
    }
    return Solver(parentMap, weightMap).solve()
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
