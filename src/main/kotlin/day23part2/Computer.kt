package day23part2

class Computer(private val program: List<String>, initialRegisters: Map<Char, Long>) {
    data class ExecutionResult(val registers: Map<Char, Long>, val jumped: Boolean, val terminated: Boolean)

    private var ip = 0
    private val registers = mutableMapOf<Char, Long>()

    init {
        registers.putAll(initialRegisters)
    }

    fun executeNextInstruction(): ExecutionResult {
        if (ip !in program.indices) {
            return ExecutionResult(registers.toMap(), jumped = false, terminated = true)
        }
        val result = executeInstruction(program[ip])
        if (!result.jumped) {
            ++ip
        }
        return result
    }

    private fun executeInstruction(instruction: String): ExecutionResult {
        val parts = instruction.split(" ")
        var jumped = false
        when (parts[0]) {
            "set" -> {
                registers[parts[1].single()] = valueOf(parts[2])
            }

            "sub" -> {
                val regId = parts[1].single()
                registers[regId] = (registers[regId] ?: 0) - valueOf(parts[2])
            }

            "mul" -> {
                val regId = parts[1].single()
                registers[regId] = (registers[regId] ?: 0) * valueOf(parts[2])
            }

            "jnz" -> {
                if (valueOf(parts[1]) != 0L) {
                    ip += valueOf(parts[2]).toInt()
                    jumped = true
                }
            }

            else -> {
                throw Exception("invalid instruction: $instruction")
            }
        }
        return ExecutionResult(registers.toMap(), jumped, terminated = false)
    }

    private fun valueOf(registerOrNumber: String): Long {
        return if (registerOrNumber.length == 1 && registerOrNumber[0] in 'a'..'z') registers[registerOrNumber[0]]
            ?: 0 else registerOrNumber.toLong()
    }
}
