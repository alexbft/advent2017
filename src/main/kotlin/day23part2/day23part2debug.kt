package day23part2

import bootstrap.Bootstrap

private fun formatRegisters(registers: Map<Char, Long>): String {
    return buildList {
        for (c in 'a'..'h') {
            if (c in registers) {
                add("$c=${registers[c]}")
            }
        }
    }.joinToString(" ")
}

fun solve(program: List<String>): Int {
    val computer = Computer(program, mapOf('a' to 1))
    var instrCount = 0
    var prevH: Long? = null
    do {
        val result = computer.executeNextInstruction()
        ++instrCount
        if (result.registers['h'] != prevH) {
            prevH = result.registers['h']
            println("DEBUG $instrCount: ${formatRegisters(result.registers)}")
        }
        if (instrCount % 1000000 == 0) {
            println("DEBUG $instrCount: ${formatRegisters(result.registers)}")
        }
    } while (instrCount < 100_000_000)
    return 0
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
