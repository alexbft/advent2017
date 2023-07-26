package day18part2

import bootstrap.Bootstrap

private data class ExecutionResult(
    val sentValue: Long?,
    val rcvWait: Boolean,
    val jumped: Boolean,
    val terminated: Boolean)

private class Computer(id: Int, private val program: List<String>) {
    private var ip = 0
    private val registers = mutableMapOf<Char, Long>()
    private val rcvBuffer = ArrayDeque<Long>()
    var sendCount = 0
        private set

    init {
        registers['p'] = id.toLong()
    }

    fun executeNextInstruction(): ExecutionResult {
        if (ip !in program.indices) {
            return ExecutionResult(sentValue = null, rcvWait = false, jumped = false, terminated = true)
        }
        val result = executeInstruction(program[ip])
        if (!result.jumped) {
            ++ip
        }
        return result
    }

    fun receiveData(data: Long) {
        rcvBuffer.addLast(data)
    }

    private fun executeInstruction(instruction: String): ExecutionResult {
        val parts = instruction.split(" ")
        var sentValue: Long? = null
        var jumped = false
        var rcvWait = false
        when (parts[0]) {
            "snd" -> {
                sentValue = valueOf(parts[1])
                sendCount += 1
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
                if (rcvBuffer.isEmpty()) {
                    rcvWait = true
                    jumped = true
                } else {
                    registers[parts[1].single()] = rcvBuffer.removeFirst()
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
        return ExecutionResult(sentValue, rcvWait, jumped, terminated = false)
    }

    private fun valueOf(registerOrNumber: String): Long {
        return if (registerOrNumber.length == 1 && registerOrNumber[0] in 'a'..'z') registers[registerOrNumber[0]]
            ?: 0 else registerOrNumber.toLong()
    }

}

fun solve(program: List<String>): Int {
    val cpu0 = Computer(0, program)
    val cpu1 = Computer(1, program)
    outer@while (true) {
        val result0 = cpu0.executeNextInstruction()
        if (result0.terminated || result0.rcvWait) {
            var result1: ExecutionResult
            do {
                result1 = cpu1.executeNextInstruction()
                if (result1.terminated || result1.rcvWait) {
                    break@outer
                }
            } while (result1.sentValue == null)
            cpu0.receiveData(result1.sentValue!!)
        }
        if (result0.sentValue != null) {
            cpu1.receiveData(result0.sentValue)
        }
    }
    return cpu1.sendCount
}

fun main(args: Array<String>) = println(solve(Bootstrap(args).readAllLines()))
