package day20part1

import bootstrap.Bootstrap
import kotlin.math.abs

data class Vector3(val x: Long, val y: Long, val z: Long) {
//    operator fun plus(other: Vector3) = Vector3(x + other.x, y + other.y, z + other.z)
    fun manhattanDistance(): Long {
        return abs(x) + abs(y) + abs(z)
    }
    companion object {
        fun parse(csv: String): Vector3 {
            val values = csv.split(",").map { it.toLong() }
            return Vector3(values[0], values[1], values[2])
        }
    }
}
data class Particle(val position: Vector3, val velocity: Vector3, val acceleration: Vector3) {
//    fun step(): Particle {
//        val newVel = velocity + acceleration
//        val newPos = position + newVel
//        return Particle(newPos, newVel, acceleration)
//    }
}

fun solve(lines: List<String>): Int {
    val re = """p=<(.+)>, v=<(.+)>, a=<(.+)>""".toRegex()
    val particles = mutableListOf<Particle>()
    for (line in lines) {
        val match = re.matchEntire(line) ?: throw Exception("no match")
        val groups = match.groupValues.subList(1, 4).map { Vector3.parse(it) }
        particles.add(Particle(groups[0], groups[1], groups[2]))
    }
    return particles.withIndex().minBy { it.value.acceleration.manhattanDistance() }.index
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
