package day23part2

fun main() {
    var b = 109900L
    val c = 126900L
    var d = 0L
    var e = 0L
    var f = 0L
    var g = 0L
    var h = 0L
    while (true) {
        f = 1L
        d = 2L
        do {
            //println("b=$b c=$c d=$d e=$e f=$f g=$g h=$h")
            e = 2L
            do {
                g = d * e - b
                if (g == 0L) {
                    f = 0L
                }
                e += 1L
                g = e - b
            } while (g != 0L)
            d += 1L
            g = d - b
        } while (g != 0L)
        if (f == 0L) {
            h += 1L
            println("b=$b c=$c d=$d e=$e f=$f g=$g h=$h")
            break
        }
        g = b - c
        if (g == 0L) {
            break
        }
        b += 17
    }
}
