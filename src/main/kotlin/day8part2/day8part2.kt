package day8part2

import bootstrap.Bootstrap

private fun checkCondition(op: String, a: Int, b: Int): Boolean {
    return when (op) {
        ">" -> a > b
        "<" -> a < b
        ">=" -> a >= b
        "<=" -> a <= b
        "==" -> a == b
        "!=" -> a != b
        else -> throw Exception("Unhandled op: $op")
    }
}

fun solve(lines: List<String>): Int {
    val lineRe = """(?<reg>\w+) (?<op>inc|dec) (?<opValue>-?\d+) if (?<condReg>\w+) (?<condOp>.{1,2}) (?<condValue>-?\d+)""".toRegex()
    val registers = mutableMapOf<String, Int>()
    val allValues = mutableListOf(0)
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("unmatched $line")
        val condReg = match.groups["condReg"]!!.value
        val condOp = match.groups["condOp"]!!.value
        val condValue = match.groups["condValue"]!!.value.toInt()
        val regValue = registers[condReg] ?: 0
        if (checkCondition(condOp, regValue, condValue)) {
            val reg = match.groups["reg"]!!.value
            val op = match.groups["op"]!!.value
            val opValue = match.groups["opValue"]!!.value.toInt()
            val curValue = registers[reg] ?: 0
            val newValue = if (op == "inc") curValue + opValue else curValue - opValue
            allValues.add(newValue)
            registers[reg] = newValue
        }
    }
    return allValues.max()
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
