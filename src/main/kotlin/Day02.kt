fun main() {
    val input = readInput("Day02")
    val day02 = Day02()
    val part1Result = day02.part1(input)
    val part2Result = day02.part2(input)

    println("############################ ")
    println(" Part 1 result: $part1Result")
    println(" Part 2 result: $part2Result")
}

class Day02 {

    private data class Position(var x: Int = 0, var y: Int = 0, var aim: Int = 0) {
        val result by lazy { x * y }
    }

    fun part1(input: List<String>): Int {
        val forward: (Position, Int) -> Unit = { position, value -> position.x += value }
        val down: (Position, Int) -> Unit = { position, value -> position.y += value }
        val up: (Position, Int) -> Unit = { position, value -> position.y -= value }

        return process(input, forward, down, up)
    }

    fun part2(input: List<String>): Int {
        val forward: (Position, Int) -> Unit = { position, value ->
                position.y += position.aim * value
                position.x += value
            }
        val down: (Position, Int) -> Unit = { position, value -> position.aim += value }
        val up: (Position, Int) -> Unit = { position, value -> position.aim -= value }

        return process(input, forward, down, up)
    }

    private fun process(
        input: List<String>,
        forward: (Position, Int) -> Unit,
        down: (Position, Int) -> Unit,
        up: (Position, Int) -> Unit
    ): Int {
        val position = Position()

        input.forEach { command ->
            val (keyword: String, value: String) = command.split(" ")

            when (keyword) {
                "forward" -> forward.invoke(position, value.toInt())
                "down" -> down.invoke(position, value.toInt())
                "up" -> up.invoke(position, value.toInt())
                else -> throw IllegalStateException("Unknown keyword")
            }

            println(position)
        }

        return position.result
    }
}
