package day9part1

import bootstrap.Bootstrap

private class Reader(private val text: String) {
    private var pos = 0
    private var groupDepth = 0
    var score = 0
        private set
    val isEndOfString: Boolean
        get() = pos >= text.length

    fun readItem() {
        when (readChar()) {
            '{' -> readGroup()
            '<' -> readGarbage()
            else -> throw makeError("Unexpected char at item start")
        }
    }

    private fun readGroup() {
        groupDepth += 1
        while (true) {
            if (peekChar() != '}') {
                readItem()
            }
            when (readChar()) {
                ',' -> {}
                '}' -> {
                    score += groupDepth
                    groupDepth -= 1
                    return
                }
                else -> throw makeError("Unexpected char in group")
            }
        }
    }

    private fun readGarbage() {
        while (true) {
            when (readChar()) {
                '!' -> readChar()
                '>' -> return
            }
        }
    }

    private fun readChar(): Char {
        if (isEndOfString) {
            throw makeError("Unexpected EOS")
        }
        return text[pos++]
    }

    private fun peekChar(): Char {
        if (isEndOfString) {
            throw makeError("Unexpected EOS")
        }
        return text[pos]
    }

    private fun makeError(message: String): Exception {
        return Exception("$message at pos $pos")
    }
}

fun solve(text: String): Int {
    val reader = Reader(text)
    reader.readItem()
    if (!reader.isEndOfString) {
        throw Exception("unexpected extra chars")
    }
    return reader.score
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllText().trimEnd()))
}
