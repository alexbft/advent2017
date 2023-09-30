package day20part2

import bootstrap.Bootstrap
import kotlin.math.abs

data class Vector3(val x: Long, val y: Long, val z: Long) {
    operator fun plus(other: Vector3) = Vector3(x + other.x, y + other.y, z + other.z)
    companion object {
        fun parse(csv: String): Vector3 {
            val values = csv.split(",").map { it.toLong() }
            return Vector3(values[0], values[1], values[2])
        }
    }
}
data class Particle(val position: Vector3, val velocity: Vector3, val acceleration: Vector3) {
    fun step(): Particle {
        val newVel = velocity + acceleration
        val newPos = position + newVel
        return Particle(newPos, newVel, acceleration)
    }
}

fun onlyUnique(particles: List<Particle>): List<Particle> {
    return particles.groupBy { it.position }.values.flatMap { if (it.size > 1) emptyList() else it }
}

fun solve(lines: List<String>): Int {
    val re = """p=<(.+)>, v=<(.+)>, a=<(.+)>""".toRegex()
    var particles = buildList {
        for (line in lines) {
            val match = re.matchEntire(line) ?: throw Exception("no match")
            val groups = match.groupValues.subList(1, 4).map { Vector3.parse(it) }
            add(Particle(groups[0], groups[1], groups[2]))
        }
    }
    particles = onlyUnique(particles)
    for (i in 0..10000) {
       particles = particles.map { it.step() }.let { onlyUnique(it) }
    }
    return particles.size
}

fun main(args: Array<String>) {
    println(solve(Bootstrap(args).readAllLines()))
}
