package day23part1

import bootstrap.Bootstrap

fun solve(program: List<String>): Int {
    val computer = Computer(program)
    var mulCount = 0
    do {
        val result = computer.executeNextInstruction()
        if (result.executedCommand == "mul") {
            ++mulCount
        }
    } while (!result.terminated)
    return mulCount
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
