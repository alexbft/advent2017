package day18part1

import bootstrap.Bootstrap

private data class ExecutionResult(val rcvValue: Long?, val jumped: Boolean, val terminated: Boolean)

private class Computer(private val program: List<String>) {
    private var ip = 0
    private val registers = mutableMapOf<Char, Long>()
    private var lastSoundPlayed: Long? = null

    fun executeNextInstruction(): ExecutionResult {
        if (ip !in program.indices) {
            return ExecutionResult(rcvValue = null, jumped = false, terminated = true)
        }
        val result = executeInstruction(program[ip])
        if (!result.jumped) {
            ++ip
        }
        return result
    }

    private fun executeInstruction(instruction: String): ExecutionResult {
        val parts = instruction.split(" ")
        var rcvValue: Long? = null
        var jumped = false
        when (parts[0]) {
            "snd" -> {
                lastSoundPlayed = valueOf(parts[1])
            }

            "set" -> {
                registers[parts[1].single()] = valueOf(parts[2])
            }

            "add" -> {
                val regId = parts[1].single()
                registers[regId] = (registers[regId] ?: 0) + valueOf(parts[2])
            }

            "mul" -> {
                val regId = parts[1].single()
                registers[regId] = (registers[regId] ?: 0) * valueOf(parts[2])
            }

            "mod" -> {
                val regId = parts[1].single()
                registers[regId] = (registers[regId] ?: 0) % valueOf(parts[2])
            }

            "rcv" -> {
                if (valueOf(parts[1]) != 0L) {
                    rcvValue = lastSoundPlayed
                }
            }

            "jgz" -> {
                if (valueOf(parts[1]) > 0L) {
                    ip += valueOf(parts[2]).toInt()
                    jumped = true
                }
            }

            else -> {
                throw Exception("invalid instruction: $instruction")
            }
        }
        return ExecutionResult(rcvValue, jumped, terminated = false)
    }

    private fun valueOf(registerOrNumber: String): Long {
        return if (registerOrNumber.length == 1 && registerOrNumber[0] in 'a'..'z') registers[registerOrNumber[0]]
            ?: 0 else registerOrNumber.toLong()
    }

}

fun solve(program: List<String>): Long {
    val cpu = Computer(program)
    var result: ExecutionResult
    do {
        result = cpu.executeNextInstruction()
    } while (!result.terminated && result.rcvValue == null)
    if (result.terminated) {
        throw Exception("Terminated")
    }
    return result.rcvValue!!
}

fun main(args: Array<String>) = println(solve(Bootstrap(args).readAllLines()))
