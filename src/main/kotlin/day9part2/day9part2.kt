package day9part2

import bootstrap.Bootstrap

private class Reader(private val text: String) {
    private var pos = 0
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
        while (true) {
            if (peekChar() != '}') {
                readItem()
            }
            when (readChar()) {
                ',' -> {}
                '}' -> return
                else -> throw makeError("Unexpected char in group")
            }
        }
    }

    private fun readGarbage() {
        while (true) {
            when (readChar()) {
                '!' -> readChar()
                '>' -> return
                else -> ++score
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
