package day25part1

import bootstrap.Bootstrap

private data class Rule(
    val state: Char,
    val tapeValue: Int,
    val newValue: Int,
    val posChange: Int,
    val newState: Char,
)

private class Tape {
    private val left = mutableListOf<Int>()
    private val right = mutableListOf(0)
    private var pos = 0

    val all: List<Int> get() = left.reversed() + right

    fun getValue() = if (pos >= 0) right[pos] else left[-1 - pos]
    fun setValue(value: Int) {
        if (pos >= 0) {
            right[pos] = value
        } else {
            left[-1 - pos] = value
        }
    }

    fun move(posChange: Int) {
        if (posChange != 1 && posChange != -1) {
            throw Exception("Invalid move: $posChange")
        }
        pos += posChange
        if (pos >= 0 && posChange > 0) {
            if (pos >= right.size) {
                right.add(0)
            }
        } else if (pos < 0 && posChange < 0) {
            val leftPos = -1 - pos
            if (leftPos >= left.size) {
                left.add(0)
            }
        }
    }
}

private fun parsePosChange(posChangeStr: String): Int {
    return if (posChangeStr == "left") -1 else 1
}

fun solve(lines: List<String>): Int {
    val steps =
        """Perform a diagnostic checksum after (\d+) steps\.""".toRegex().matchEntire(lines[1])!!.groupValues[1].toInt()
    val blocks = lines.slice(3 until lines.size).joinToString("\n").split("\n\n")
    val blockRe = """
        In state ([A-Z]):
          If the current value is 0:
            - Write the value ([01])\.
            - Move one slot to the (left|right)\.
            - Continue with state ([A-Z])\.
          If the current value is 1:
            - Write the value ([01])\.
            - Move one slot to the (left|right)\.
            - Continue with state ([A-Z])\.
    """.trimIndent().toRegex()
    val rules = mutableListOf<Rule>()
    for (block in blocks) {
        val match = blockRe.matchEntire(block) ?: throw Exception("No match for: $block")
        val (_, state, newValue0, posChange0, newState0) = match.groupValues
        val (newValue1, posChange1, newState1) = match.groupValues.slice(5..7)
        rules.add(Rule(state.single(), 0, newValue0.toInt(), parsePosChange(posChange0), newState0.single()))
        rules.add(Rule(state.single(), 1, newValue1.toInt(), parsePosChange(posChange1), newState1.single()))
    }
    val tape = Tape()
    var state = 'A'
    for (step in 0 until steps) {
        val tapeValue = tape.getValue()
        val rule = rules.find { it.state == state && it.tapeValue == tapeValue }
            ?: throw Exception("Rule not found for state = $state and value = $tapeValue")
        tape.setValue(rule.newValue)
        tape.move(rule.posChange)
        state = rule.newState
    }
    return tape.all.count { it == 1 }
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
